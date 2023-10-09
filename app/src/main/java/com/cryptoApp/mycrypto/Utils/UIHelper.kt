package com.cryptoApp.mycrypto.Utils

import android.widget.TextView
import androidx.core.content.ContextCompat
import com.emmanuel_rono.mycrypto.R
class UIHelper {
    object UIHelper {

        fun showChangePercent(textView: TextView, _change: Double?) {
            val changePercent = "%.2f %%".format(_change).trimParanthesis()

            textView.text = changePercent
            val context = textView.context
            if (changePercent.contains("-")) {
                textView.setTextColor(
                    ContextCompat.getColor(context, R.color.red)
                )
                textView.setCompoundDrawablesWithIntrinsicBounds(
                    null, null,
                    ContextCompat.getDrawable(context, R.drawable.ic_baseline_arrow_downward_24),
                    null
                )
            } else {
                textView.setTextColor(
                    ContextCompat.getColor(context, R.color.green)
                )
                textView.setCompoundDrawablesWithIntrinsicBounds(
                    null, null,
                    ContextCompat.getDrawable(context, R.drawable.ic_baseline_arrow_upward_24),
                    null
                )
            }
        }
    }
}