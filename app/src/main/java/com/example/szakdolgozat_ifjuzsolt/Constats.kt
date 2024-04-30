package com.example.szakdolgozat_ifjuzsolt

object Constats{
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS:String = "total_questions"
    const val CORRECT_ANSWERS:String = "correct_answers"

    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()
        val que1 = Question(1, "Mia változó?",
            "Entitás/Tárolók",
            "Osztályok",
            "Hivatkozások",
            "Tulajdonságok",
            1
        )
        questionsList.add(que1)

        val que2 = Question(2, "Melyik szam alapu valtozo?",
            "Bool",
            "String",
            "Int",
            "For",
            3
        )
        questionsList.add(que2)

        val que3 = Question(3, "Melyik nem a programozás koncepciója",
            "Változók",
            "Elágazások",
            "Ciklusok",
            "Törvények",
            4
        )
        questionsList.add(que3)

        val que4 = Question(4, "Mi az if?",
            "Elágazás",
            "Ciklus",
            "Léptetett Ciklus",
            "Nincs ilyen",
            1
        )
        questionsList.add(que4)

        val que5 = Question(5, "Mit nem fejleszt a programozás tanulása",
            "Türelem",
            "Kreativitás",
            "Probléma megoldó készség",
            "Ezek közül mindent",
            1
        )
        questionsList.add(que5)

        val que6 = Question(6, "Melyik a feltételes ciklus?",
            "For",
            "While",
            "If",
            "Switch",
            2
        )
        questionsList.add(que6)

        val que7 = Question(7, "A for milyen ciklus?",
            "Léptetett/iterációs",
            "Feltételes",
            "A for nem is egy ciklus",
            "Utántesztelős",
            1
        )
        questionsList.add(que7)

        val que8 = Question(8, "Melyik nem programozási nyelv?",
            "C++",
            "Java",
            "C#",
            "Mind programozási nyelv",
            4
        )
        questionsList.add(que8)

        val que9 = Question(9, "Mi a feltétel a programozásban?",
            "Ciklus",
            "Elágazás",
            "Értékadás",
            "A programozásbanincs ilyen",
            2
        )
        questionsList.add(que9)

        val que10 = Question(10, "Mi a változók scope-ja?",
            "Művelete",
            "Változók kiterjesztése",
            "Változók értékadása",
            "Változók hatóköre",
            4
        )
        questionsList.add(que10)






        return questionsList
    }
}