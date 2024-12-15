package com.example.dual_selection_platform_back.mapper;

import com.example.dual_selection_platform_back.model.CandidateChoices;
import java.util.List;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CandidateChoicesMapper {
    /**
     * 查询所有记录
     * @returns
     */
    @Results({
            @Result(property = "StudentName",column = "StudentName"),
            @Result(property = "AdmissionTicketNumber",column = "AdmissionTicketNumber"),
            @Result(property = "Priority",column = "Priority"),
            @Result(property = "MentorName",column = "MentorName"),
            @Result(property = "Discipline",column = "Discipline"),
            @Result(property = "Field",column = "Field"),
            @Result(property = "Status",column = "Status"),
            @Result(property = "Detail",column = "Detail"),
            @Result(property = "InitialScores",column = "InitialScores"),
            @Result(property = "SecondScores",column = "SecondScores"),
            @Result(property = "TotalQuota",column = "TotalQuota"),
            @Result(property = "AdmittedQuota",column = "AdmittedQuota"),

    })
    @Select("SELECT StudentName,AdmissionTicketNumber,Priority,MentorName,Discipline,Field,Status,Detail,InitialScores,SecondScores FROM CandidateChoices")
    List<CandidateChoices> selectAllChoices_Status_Scores();

    @Select("select StudentName,AdmissionTicketNumber,Priority,MentorName,Field,Discipline,Status,Detail FROM CandidateChoices where StatusId=2")
    List<CandidateChoices> selectAllQuestion();

    @Select("select MentorName,Discipline,Field,StudentName,Status from CandidateChoices where StatusId=1")
    List<CandidateChoices> selectAllResult();

    @Select("select MentorID,MentorName,Discipline,Field,StudentName,Priority,`Status` from CandidateChoices   order by MentorName,Discipline,Field asc ")
    List<CandidateChoices> selectAllMentorSelected();
}
