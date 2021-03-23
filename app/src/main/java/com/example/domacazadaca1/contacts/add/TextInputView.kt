package com.example.domacazadaca1.contacts.add

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.domacazadaca1.R
import com.example.domacazadaca1.databinding.InputEdittextBinding

enum class DataType{
    NUMBER, STRING, MAIL
}


class TextInputView(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs) {

    private var binding: InputEdittextBinding

    var label_text: String?
    var hint_text: String?

    init {
        val layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = InputEdittextBinding.inflate(layoutInflater)
        inflate(context, R.layout.input_edittext, binding.root)
        addView(binding.root)

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.TextInputView,
            0, 0).apply {
            try {
                label_text = getString(R.styleable.TextInputView_label)
                hint_text = getString(R.styleable.TextInputView_input)
                val dataType = getInt(R.styleable.TextInputView_dataType, DataType.NUMBER.ordinal)
                val length = getInt(R.styleable.TextInputView_stringLength, 0)
                when (dataType) {
                    DataType.NUMBER.ordinal -> {
                        binding.input.inputType = InputType.TYPE_CLASS_NUMBER
                    }
                    DataType.STRING.ordinal -> {

                    }
                    DataType.MAIL.ordinal -> {

                    }
                }
                binding.label.text = label_text
                binding.input.hint = hint_text
            }
            finally {
                recycle()
            }
        }
    }

}
