package ir.myket.interview.myket_task_kotlin.utill

import java.util.HashMap
import javax.inject.Inject

class CalculateLastRating @Inject constructor() {
    private val mPrograms = HashMap<Int,Float>()
    private  var mMostRate : Float = 0.0f
    private var mMostPosition=0

    fun check(position:Int,rating:Float) : Boolean{
        for(i in mMostPosition until mPrograms.size-1 ){
            if (position>i && rating>=mMostRate){
                mMostRate = rating
                mMostPosition = position
                mPrograms.put(position,rating)
                return true
            }
        }
        mPrograms.put(position,rating)
        return false
    }

}