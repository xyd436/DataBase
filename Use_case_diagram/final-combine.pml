@startuml

left to right direction
skinparam packageStyle rectangle

actor "学院管理员" as CollegeAdmin
actor "考生" as Student
actor "研究生院" as GraduateSchool
actor "学校" as School
actor "导师" as Mentor
actor "学科秘书" as DepartmentSecretary
actor "学科负责人" as DepartmentHead
actor "研究生管理秘书" as GraduateSecretary
actor "研究生主管领导" as GraduateLeader
actor "监督成员" as Supervisor
   
rectangle "复试过程导师与学生分配管理系统" {
     usecase "导师遴选" as UC_A1
    usecase "审核导师资格" as UC_A2
    usecase "编制招生目录" as UC_A3
    usecase "发布招生目录" as UC_A4
    usecase "分配招生指标" as UC_A5
    usecase "补充招生指标" as UC_A6
    usecase "审核招生目录" as UC_A7
    usecase "查看招生目录" as UC_A8

    usecase "提交个人材料" as UC_B1
    usecase "导入初试成绩" as UC_B2
    usecase "导入复试成绩" as UC_B3
    usecase "确定录取状态" as UC_B4
    usecase "提交导师选择志愿" as UC_B5

    usecase "填报个人信息和导师志愿" as UC_C1
    usecase "查看复试录取结果" as UC_C2
    usecase "维护个人简介" as UC_C3
    usecase "确认选择的学生" as UC_C4
    usecase "查看选择结果" as UC_C5
    usecase "质疑学生志愿情况提出复核" as UC_C6
    usecase "签字确认学生报名表" as UC_C7
    usecase "推动导师选择过程" as UC_C8
    usecase "查看考生信息和导师志愿" as UC_C9
    usecase "查看导师选择结果" as UC_C10
    usecase "查看导师招生指标" as UC_C11
    usecase "查看未匹配到导师的考生" as UC_C12
    usecase "下发报考导师志愿的学生信息" as UC_C13
    usecase "组织没有学生报考志愿的导师抽签" as UC_C14
    usecase "根据导师招生指标数剩余情况分批次抽签" as UC_C15
    usecase "确定学科研究方向" as UC_C16
    usecase "下发拟录取学生信息" as UC_C17
    usecase "公布师生选择结果" as UC_C18
    usecase "公示各学科导师的招生人数信息" as UC_C19
    usecase "提交各学科导师的招生人数信息" as UC_C20
    usecase "上报各学科导师的招生人数信息" as UC_C21
    usecase "录入初试与复试信息" as UC_C22
    usecase "审核复试信息" as UC_C23
    usecase "发布录取公示结果" as UC_C24
    usecase "审议考生与导师选择结果" as UC_C25
    usecase "复核导师质疑" as UC_C26
    usecase "查看复试过程" as UC_C27
    usecase "接收审议后的招生人数信息" as UC_C28


    CollegeAdmin --> UC_A1
    CollegeAdmin --> UC_A2
    CollegeAdmin --> UC_A3
    CollegeAdmin --> UC_A4

    GraduateSchool --> UC_A5
    GraduateSchool --> UC_A6
    
    School --> UC_A7
    
    Student --> UC_A8

    Student --> UC_B1
    CollegeAdmin --> UC_B2
    CollegeAdmin --> UC_B3
    CollegeAdmin --> UC_B4
    Student --> UC_B5

    Student --> UC_C1
    Student --> UC_C2

    Mentor --> UC_C3
    Mentor --> UC_C4
    Mentor --> UC_C5
    Mentor --> UC_C6
    Mentor --> UC_C7

    DepartmentSecretary --> UC_C8
    DepartmentSecretary --> UC_C9
    DepartmentSecretary --> UC_C10
    DepartmentSecretary --> UC_C11
    DepartmentSecretary --> UC_C12
    DepartmentSecretary --> UC_C13
    DepartmentSecretary --> UC_C14
    DepartmentSecretary --> UC_C15

    DepartmentHead --> UC_C16
    DepartmentHead --> UC_C17
    DepartmentHead --> UC_C18
    DepartmentHead --> UC_C19
    DepartmentHead --> UC_C20
    DepartmentHead --> UC_C21

    GraduateSecretary --> UC_C22
    GraduateSecretary --> UC_C23
    GraduateSecretary --> UC_C24

    GraduateLeader --> UC_C25
    GraduateLeader --> UC_C26

    Supervisor --> UC_C27

    GraduateSchool --> UC_C28


    UC_A1 --> UC_A3 : <<include>>
    UC_A2 --> UC_A3 : <<include>>
    UC_A3 --> UC_A7
    UC_A7 --> UC_A4
    UC_A4 .> UC_A8 : <<extend>>
    UC_A5 --> UC_A3 : <<include>>
    UC_A6 .> UC_A3 : <<extend>>

    UC_B1 --> UC_B4 : <<include>>
    UC_B2 --> UC_B4 : <<include>>
    UC_B3 --> UC_B4 : <<include>>
    UC_B4 .> UC_B5 : <<extend>>

    UC_C4 -down-> UC_C5 : <<include>>
    UC_C6 -left-> UC_C5 : <<extend>>
    UC_C8 -down-> UC_C9 : <<include>>
    UC_C9 -left-> UC_C10 : <<extend>>
    UC_C9 -down-> UC_C11 : <<include>>
    UC_C12 -down-> UC_C11 : <<extend>>
    UC_C13 -down-> UC_C14 : <<include>>
    UC_C16 -down-> UC_C17 : <<extend>>
    UC_C18 -down-> UC_C19 : <<include>>
    UC_C20 -down-> UC_C19 : <<extend>>
    UC_C24 -down-> UC_C23 : <<include>>
    UC_C25 -down-> UC_C26 : <<include>>
    UC_C10 -down-> UC_C9 : <<generalization>>
}

@enduml
