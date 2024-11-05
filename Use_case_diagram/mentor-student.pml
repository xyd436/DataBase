@startuml
left to right direction
skinparam packageStyle rectangle

actor 考生 as Student
actor 导师 as Mentor
actor 学科秘书 as Secretary
actor 学科负责人 as DepartmentHead
actor 研究生管理秘书 as GradSecretary
actor 研究生主管领导 as Dean
actor 监督成员 as Supervisor
actor 学院研究生招生工作领导小组 as AdmissionsCommittee
actor 研究生院 as GraduateSchool

rectangle 复试过程导师与学生分配管理系统 {
  (填报个人信息和导师志愿) as UC1
  (查看复试录取结果) as UC2
  (维护个人简介) as UC3
  (确认选择的学生) as UC4
  (查看选择结果) as UC5
  (质疑学生志愿情况提出复核) as UC6
  (签字确认学生报名表) as UC7
  (推动导师选择过程) as UC8
  (查看考生个人信息和导师志愿) as UC9
  (查看导师选择结果) as UC10
  (查看导师招生指标数) as UC11
  (查看是否有未匹配到导师的考生) as UC12
  (下发报考导师第一~三志愿的学生信息) as UC13
  (组织没有学生报考志愿的导师抽签确定选择学生顺序) as UC14
  (根据导师招生指标数剩余情况分批次抽签决定选择学生顺序) as UC15
  (确定学科研究方向) as UC16
  (下发拟录取学生的招生信息) as UC17
  (公布师生选择确定情况) as UC18
  (公示各学科导师的招生人数信息) as UC19
  (提交各学科导师的招生人数信息) as UC20
  (上报各学科导师的招生人数信息到研究生院) as UC21
  (录入考生初试信息) as UC22
  (录入考生复试信息) as UC23
  (审核复试考生信息) as UC24
  (发布录取公示结果) as UC25
  (审议考生和导师选择结果) as UC26
  (复核导师对志愿学生情况的质疑) as UC27
  (查看全过程) as UC28
  (审议各学科导师的招生人数信息) as UC29
  (接收审议后的各学科导师的招生人数信息) as UC30
}

Student --> UC1
Student --> UC2
Mentor --> UC3
Mentor --> UC4
Mentor --> UC5
Mentor --> UC6
Mentor --> UC7
Secretary --> UC8
Secretary --> UC9
Secretary --> UC10
Secretary --> UC11
Secretary --> UC12
Secretary --> UC13
Secretary --> UC14
Secretary --> UC15
DepartmentHead --> UC16
DepartmentHead --> UC17
DepartmentHead --> UC18
DepartmentHead --> UC19
DepartmentHead --> UC20
DepartmentHead --> UC21
GradSecretary --> UC22
GradSecretary --> UC23
GradSecretary --> UC24
GradSecretary --> UC25
Dean --> UC26
Dean --> UC27
Supervisor --> UC28
AdmissionsCommittee --> UC29
GraduateSchool --> UC30

UC4 -down-> UC5 : 包含
UC6 -left-> UC5 : 扩展
UC8 -down-> UC9 : 包含
UC9 -left-> UC10 : 扩展
UC9 -down-> UC11 : 包含
UC12 -down-> UC11 : 扩展
UC13 -down-> UC14 : 包含
UC16 -down-> UC15 : 扩展
UC18 -down-> UC17 : 包含
UC20 -down-> UC19 : 包含
UC24 -down-> UC25 : 包含
UC21 -down-> UC22 : 包含
UC10 -down-> UC9 : 泛化

@enduml