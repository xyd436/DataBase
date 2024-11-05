@startuml

left to right direction
skinparam packageStyle rectangle

actor 考生
actor 学院管理员
actor 导师

rectangle 研究生招生管理系统 {
  usecase "提交个人材料" as UC1
  usecase "导入初试成绩" as UC2
  usecase "导入复试成绩" as UC3
  usecase "确定录取状态" as UC4
  usecase "提交导师选择志愿" as UC5
}

考生 --> UC1
学院管理员 --> UC2
学院管理员 --> UC3
学院管理员 --> UC4
考生 --> UC5

UC1 --> UC4 : <<include>>
UC2 --> UC4 : <<include>>
UC3 --> UC4 : <<include>>
UC4 .> UC5 : <<extend>>

@enduml
