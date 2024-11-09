@startuml
left to right direction
skinparam packageStyle rectangle

actor "考生" as student
actor "导师" as mentor
actor "学科秘书" as departmentSecretary
actor "学科负责人" as departmentHead
actor "研究生管理秘书" as graduateSecretary
actor "研究生主管领导" as graduateLeader
actor "监督成员" as supervisor
actor "研究生院" as graduateSchool

rectangle 复试过程导师与学生分配管理系统 {
    usecase "填报个人信息和导师志愿" as UC1
    usecase "查看复试录取结果" as UC2
    usecase "维护个人简介" as UC3
    usecase "确认选择的学生" as UC4
    usecase "查看选择结果" as UC5
    usecase "质疑学生志愿情况提出复核" as UC6
    usecase "签字确认学生报名表" as UC7
    usecase "推动导师选择过程" as UC8
    usecase "查看考生信息和导师志愿" as UC9
    usecase "查看导师选择结果" as UC10
    usecase "查看导师招生指标" as UC11
    usecase "查看未匹配到导师的考生" as UC12
    usecase "下发报考导师志愿的学生信息" as UC13
    usecase "组织没有学生报考志愿的导师抽签" as UC14
    usecase "根据导师招生指标数剩余情况分批次抽签" as UC15
    usecase "确定学科研究方向" as UC16
    usecase "下发拟录取学生信息" as UC17
    usecase "公布师生选择结果" as UC18
    usecase "公示各学科导师的招生人数信息" as UC19
    usecase "提交各学科导师的招生人数信息" as UC20
    usecase "上报各学科导师的招生人数信息" as UC21
    usecase "录入初试与复试信息" as UC22
    usecase "审核复试信息" as UC23
    usecase "发布录取公示结果" as UC24
    usecase "审议考生与导师选择结果" as UC25
    usecase "复核导师质疑" as UC26
    usecase "查看复试过程" as UC27
    usecase "接收审议后的招生人数信息" as UC28
}

' 参与者与用例的关联
student --> UC1
student --> UC2

mentor --> UC3
mentor --> UC4
mentor --> UC5
mentor --> UC6
mentor --> UC7

departmentSecretary --> UC8
departmentSecretary --> UC9
departmentSecretary --> UC10
departmentSecretary --> UC11
departmentSecretary --> UC12
departmentSecretary --> UC13
departmentSecretary --> UC14
departmentSecretary --> UC15

departmentHead --> UC16
departmentHead --> UC17
departmentHead --> UC18
departmentHead --> UC19
departmentHead --> UC20
departmentHead --> UC21

graduateSecretary --> UC22
graduateSecretary --> UC23
graduateSecretary --> UC24

graduateLeader --> UC25
graduateLeader --> UC26

supervisor --> UC27

graduateSchool --> UC28

' 用例之间的关系
UC4 -down-> UC5 : 包含
UC6 -left-> UC5 : 扩展
UC8 -down-> UC9 : 包含
UC9 -left-> UC10 : 扩展
UC9 -down-> UC11 : 包含
UC12 -down-> UC11 : 扩展
UC13 -down-> UC14 : 包含
UC16 -down-> UC17 : 扩展
UC18 -down-> UC19 : 包含
UC20 -down-> UC19 : 扩展
UC24 -down-> UC23 : 包含
UC25 -down-> UC26 : 包含
UC10 -down-> UC9 : 泛化
@enduml
