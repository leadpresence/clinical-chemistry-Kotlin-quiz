package com.example.medlabquize

object Constants {

    const val TOTAL_QUESION:String ="Total question"
   const val CORRECT_ANSWER:String ="correct answers"
    const val USERNAME:String="username"
//    const val CORRECT_ANSWER:Int =0

    fun fetchQuestions():ArrayList<Questions>{
        val questionList=ArrayList<Questions>()
       //implement the questions

        val quest1=Questions(
            1,
            "Most important buffer system",
             2,
            "Bicarb/carbonic acid\n" +
                    "\n" +
                    "H2+ + HCO3 <--> H2CO3 <--> H2O + CO2",
            "Bicarb/carbonic acid\n" +
                    "\n" +
                    "H+ + HCO3 <--> H2CO3 <--> H2O + CO2"
        )
        questionList.add(quest1)

        val  quest2=Questions(
            2,
            "Describe Bicarbonate",

            1,
            "2nd largest fraction of anions\n"+
                    "HCO3 = CO2 - 1\tDescribe Bicarbonate\n" +
                    "H2CO3 = pCO2 x 0.03\tDescribe Carbonic acid\n" +
                    "HCO3 + H2CO3 + dCO2\tTotal CO2 formula\n" +
                    "pH = D\n" +
                    "pCO2 = I\n" +
                    "HCO3- = N",
            "2nd largest fraction of anions\n"+
                    "HCO3 = CO2 - 1\tDescribe Bicarbonate\n" +
                    "H2CO2 = pCO2 x 0.03\tDescribe Carbonic acid\n" +
                    "HCO3 + H2CO3 + dCO2\tTotal CO2 formula\n" +
                    "pH = D\n" +
                    "pCO2 = I\n" +
                    "HCO3- = N"
        )
        questionList.add(quest2)

        val quest3=Questions(
            3,
            "Describe Carbonic acid",
            2,
            "HCO3 = pCO2 x 0.03",
            "H2CO3 = pCO2 x 0.03"
        )
        questionList.add(quest3)

        val quest4=Questions(
            4,
            "Total CO2 formula",
            1,
            "HCO3 + H2CO3 + CO2",
            "HCO3 + H2CO3 + dCO2"
        )
        questionList.add(quest4)

        val quest5=Questions(
            5,
            "Respiratory acidosis:\n" +
                    "pH\n" +
                    "pCO2\n" +
                    "HCO3-\n" +
                    "Compensation" ,
            1,
            "pH = D\n" +
                    "pCO2 = I\n" +
                    "HCO3- = N\n" +
                    "Compensation = kidneys retain HCO3-, excrete H+\t",
            "pH = D\n" +
                    "pCO2 = I\n" +
                    "HCO3- = N\n" +
                    "Compensation = kidneys retain HCO3-,don't excrete H+\t"
        )
        questionList.add(quest5)
        return questionList
    }
}