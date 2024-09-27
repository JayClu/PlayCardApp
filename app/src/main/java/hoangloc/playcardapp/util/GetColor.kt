package hoangloc.playcardapp.util

import androidx.compose.ui.graphics.Color

fun GetColor(value: Int): Color
{
    when
    {
       value < 0 -> return Color(0XFFFF0000)
        value > 0 -> return Color(0xFF3F8007)
        //Color(0xFFFF0000)
        else -> return Color(0xFF030000)
    }
}