package mx.tecnm.tepic.ladm_u2_practica1_coposdenieve_saucedogarciajuanluis

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import kotlin.random.Random

class Copo(l:Lienzo) {
    val l=l
    var x=0f
    var y =0f
    var movX =2f
    var movY=0f
    var time=0
    var color= Color.WHITE
    init {
        x = randD(1000)
        y = -700f
        movY=randD(7)+3
    }
    fun mover(alt: Int, anc: Int,tiem:Int){

        if(tiem==600) {
            movY += 2
            movX += 5
        }
        if(tiem==1200) {
            movY += 4
            movX += 6
        }
        x+=movX
        y+=movY
        if(y>alt){
            y=0f
        }
        if (x>anc)
            x=0f
    }
    private fun randD(hasta : Int) : Float{
        return Random.nextDouble(hasta.toDouble()).toFloat()
    }
    private fun randI(hasta : Int) : Float{
        return Random.nextInt(hasta).toFloat()
    }

    fun pintar(canvas: Canvas){
        var p = Paint()
        p.color=color
        canvas.drawCircle(x,y,10f,p)
    }
}