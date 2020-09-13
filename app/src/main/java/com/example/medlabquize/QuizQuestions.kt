package com.example.medlabquize

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.medlabquize.Constants.CORRECT_ANSWER
import com.example.medlabquize.Constants.TOTAL_QUESION
import com.example.medlabquize.Constants.USERNAME
import com.example.medlabquize.R.drawable.correct_answer
import com.example.medlabquize.R.drawable.wrong_answer
import kotlinx.android.synthetic.main.quiz_questions_activity.*

class QuizQuestions : AppCompatActivity(),View.OnClickListener {

    private var mCurrentQstPosition:Int=1                     //hold the current question
    private var mQuestionsList:ArrayList<Questions>?=null //nullable list of options
    private var mSelectedOptionPosition:Int=0          //selected or highlighted options
    private var mUsername:String?=null
    private var mCorrectAnswers:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.quiz_questions_activity)

        //get the name passed from the main activity Intent
        mUsername=intent.getStringExtra(USERNAME)

        //get All the question
        mQuestionsList= Constants.fetchQuestions()
        questionText.text="$mUsername taking Medical Biochem Test Questions"
        //start the exercise
        setQuestion()
        optionTextOne.setOnClickListener(this)
        optionTextTwo.setOnClickListener(this)
        buttonSubmitNext.setOnClickListener(this)
    }

    fun setQuestion(){

        val question=  mQuestionsList!![mCurrentQstPosition-1]

        setDefault()

        if(mCurrentQstPosition == mQuestionsList!!.size){
            buttonSubmitNext.text="DONE"
        }else
        {
            buttonSubmitNext.text="SUBMIT"
        }
        progress.progress=mCurrentQstPosition
        progressText.text= "$mCurrentQstPosition" + "/" + progress.max
        questionText.text=question!!.question
        optionTextOne.text=question.option1
        optionTextTwo.text=question.option2
    }


    private  fun setDefault(){
        //we create an array List to hold all the options
        // and assign them default values to these with a loop

       val optionsList=ArrayList<TextView>()
        optionsList.add(0,optionTextOne)
        optionsList.add(1,optionTextTwo)

        for(option in optionsList)
        {
            //set text Color
            option.setTextColor(Color.parseColor("#000000"))
            //set typeface
            option.typeface= Typeface.DEFAULT
            //set background Image
            option.background=ContextCompat.getDrawable(
                this,
                R.drawable.option)
        }


    }

    override fun onClick(v: View?) {
        //get the view and perform selectedOption function
        //on that view i.e highlighting the border
         when(v?.id){
             R.id.optionTextOne->
             {
                 selectedOption(optionTextOne,1)

                 Log.i("Selected Position=","${mSelectedOptionPosition}")
             }
             R.id.optionTextTwo->
             {
                 selectedOption(optionTextTwo,2)

                 Log.i("Selected Position=","${mSelectedOptionPosition}")
             }

             R.id.buttonSubmitNext->{
                 //if quiz is beginning increment start quiz from the first question
                 if(mSelectedOptionPosition==0){
                     mCurrentQstPosition++

                     when{

                         mCurrentQstPosition <= mQuestionsList!!.size ->

                         {
                             setQuestion()
                         }
                         else-> {
                             //MOVE TO RESULTS ACTIVITY
                             val intent= Intent(this,Results::class.java)
                             //set values on Intent
                             intent.putExtra(USERNAME,mUsername)
                             intent.putExtra(TOTAL_QUESION,mQuestionsList!!.size.toString())
                             intent.putExtra(CORRECT_ANSWER,mCorrectAnswers)
                             startActivity(intent)
                             finish()
                         }
                     }

                 }else{
                     //when  some option is selected
                     val question=mQuestionsList?.get(mCurrentQstPosition-1)
                     if(question!!.answer!= mSelectedOptionPosition){

                         Log.i("Check Answer=","Not Correct")

                         answerView(mSelectedOptionPosition,wrong_answer)
                     }else{
                         //INCREMENT CORRECT ANSWERS GIVEN
                         mCorrectAnswers++
                         Log.i("Correct Answers=","$mCorrectAnswers")

                     }
                     Log.i("Check Answer="," Correct")

                     answerView(question.answer, correct_answer)

                     if(mCurrentQstPosition== mQuestionsList!!.size){
                         buttonSubmitNext.text="Done"
                     }
                     else
                     {
                         buttonSubmitNext.text="Next"
                     }
                         mSelectedOptionPosition=0
                 }
             }



         }

    }

    //since we would change the view of an option on selection
    //this function sets the changes one we'd see on the option

    private fun selectedOption(opt:TextView,selection:Int)
    {
        //set to default style
        setDefault()
        //get the number selected & assign to mSelectedOptionPosition initialized above
        mSelectedOptionPosition=selection
        //change type face of text to be bold
        opt.setTypeface(opt.typeface,Typeface.BOLD)
        //change the text color to black
        opt.setTextColor(Color.parseColor("#000000"))
        //set a rounded border around it to show its selected
        opt.background=ContextCompat.getDrawable(
            this,
            R.drawable.selected_option)

    }

    //we set the back ground of the answer Red or green with
    //the answerView function

    private fun answerView(answer:Int,markingColor:Int){
        when(answer){
         1->{
             optionTextOne.background=ContextCompat.getDrawable(
                    this,markingColor ) }
           2->{optionTextTwo.background=ContextCompat.getDrawable(
                this,markingColor ) }
        }


    }


}