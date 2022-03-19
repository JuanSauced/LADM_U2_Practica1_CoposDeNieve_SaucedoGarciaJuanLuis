package mx.tecnm.tepic.ladm_u2_practica1_coposdenieve_saucedogarciajuanluis

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.CountDownTimer
import android.view.View
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Lienzo(este:MainActivity): View(este) {
    val este=este
    var anoc=width.toFloat()
    var dia = 1

    private var tiempo=0


    val copos= Array<Copo>(120,{Copo(this)})
    val copos2= Array<Copo>(100,{Copo(this)})
    val copos3= Array<Copo>(100,{Copo(this)})

    val corrutina= GlobalScope.launch {
            while (true){
                tiempo++
                este.runOnUiThread {
                    invalidate()
                }
               // if (tiempo<=600)
                delay(20L)
            }
    }


    override fun onDraw(c: Canvas){
        val dN = IntArray(2)
        dN[0] = Color.rgb(244, 196, 84)
        dN[1] = Color.rgb(234,228,217)

        super.onDraw(c)
        val p= Paint()
        if(dia<1)
            c.drawColor(Color.rgb(30,33,61))
        else
            c.drawColor(Color.rgb(34,209,246))
        p.color= Color.rgb(138,131,118)
        c.drawCircle((width/2).toFloat(),(height).toFloat(),(height/2-height/10).toFloat(),p)
        if(anoc>width){
            dia*=-1
            anoc=1f
        }
        if(dia>0){
            p.color = dN[0]
        }else {
            p.color = dN[1]
        }
            c.drawCircle(anoc, 20f, 100f, p)
            anoc++
       // c.drawOval((100).toFloat(),(height/2+height/5).toFloat(),(width-100).toFloat(),(height/2+height/9).toFloat(),p)
        if (tiempo >600){
            p.style = Paint.Style.STROKE
            p.strokeWidth=20f
            p.color=Color.WHITE
            c.drawCircle((width/2).toFloat(),(height).toFloat(),(height/2-height/10).toFloat(),p)
            c.drawRect(140f,820f,960f,820f,p)
            p.strokeWidth=1f
        }
        //Casa
        p.style=Paint.Style.FILL
        p.color=Color.rgb(86,43,5)
        //c.drawRect((200).toFloat(),(height/2).toFloat(),(width-200).toFloat(),(height-height/4).toFloat(),p)
        c.drawRect(200f,920f,900f,1450f,p)
        p.color=Color.rgb(75,54,33)
        c.drawRect(140f,820f,960f,920f,p)


        p.style=Paint.Style.FILL
        p.color=Color.BLACK
        c.drawRect(245f,1015f,395f,1175f,p)
        p.color=Color.rgb(236,212,97)
        c.drawRect(250f,1020f,317f,1094f,p)
        c.drawRect(250f,1100f,317f,1168f,p)
        c.drawRect(322f,1020f,389f,1094f,p)
        c.drawRect(322f,1100f,389f,1168f,p)

        p.strokeWidth=20f
        p.color=Color.rgb(166,123,91)
        c.drawLine(140f,1700f,340f,1740f,p)
        c.drawLine(340f,1700f,140f,1740f,p)
        p.strokeWidth=1f
        if(tiempo<1200) {
            if (anoc.toInt() % 2 == 0)
                p.color = Color.RED
            else
                p.color = Color.rgb(255, 128, 0)
            c.drawOval(180f, 1580f, 300f, 1740f, p)
        }else{
            p.color=Color.BLACK
            c.drawOval(190f, 1680f, 290f, 1740f, p)
        }

        p.style=Paint.Style.FILL
        p.color=Color.rgb(191,112,6)
        c.drawRect(670f,1000f,830f,1380f,p)

        p.color =Color.rgb(238,208,157)
        p.style=Paint.Style.STROKE
        c.drawRect(680f,1010f,820f,1370f,p)
        if (tiempo >600){
            for (it in 0..copos2.size-1){
                copos2[it].pintar(c)
                copos2[it].mover(height,width,tiempo)
            }
        }
        if (tiempo >1200){
            for (it in 0..copos2.size-1){
                copos3[it].pintar(c)
                copos3[it].mover(height,width,tiempo)
            }
        }
        if(tiempo>0)
            for (it in 0..copos.size - 1) {
                copos[it].pintar(c)
                copos[it].mover(height, width, tiempo)
        }
    }

}