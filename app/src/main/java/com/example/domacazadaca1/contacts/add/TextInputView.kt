//package com.example.domacazadaca1.contacts.add
//
//import android.content.Context
//import android.util.AttributeSet
//import android.view.LayoutInflater
//import android.view.View
//import com.example.domacazadaca1.R
//import com.example.domacazadaca1.databinding.InputEdittextBinding
//
//
//class TextInputView(context: Context, attrs: AttributeSet) : View(context, attrs) {
//
//    private var binding: InputEdittextBinding
//
//    var label_text: String?
//    var hint_text: String?
//
//    init {
//        val layoutInflater =
//            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//        binding = InputEdittextBinding.inflate(layoutInflater)
//        inflate(context, R.layout.input_edittext, binding.root)
//
//        context.theme.obtainStyledAttributes(
//            attrs,
//            R.styleable.TextInputView,
//            0, 0).apply {
//            try {
//                label_text = getString(R.styleable.TextInputView_label)
//                hint_text = getString(R.styleable.TextInputView_input)
//                binding.label.text = label_text
//                binding.input.hint = hint_text
//            }
//            finally {
//                recycle()
//            }
//        }
//    }
//
//}

//<com.example.domacazadaca1.contacts.add.TextInputView
//android:layout_width="0dp"
//android:layout_height="wrap_content"
//app:label="@string/country"
//app:input="Enter country name"
//app:layout_constraintLeft_toRightOf="@id/faculty_label"
//app:layout_constraintTop_toBottomOf="@id/test_input"
//app:layout_constraintWidth_percent="0.50"
///>