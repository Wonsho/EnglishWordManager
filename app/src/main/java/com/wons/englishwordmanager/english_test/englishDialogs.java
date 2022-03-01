package com.wons.englishwordmanager.english_test;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wons.englishwordmanager.R;
import com.wons.englishwordmanager.values.Word;

public class englishDialogs {
    public AlertDialog getTestDialog(Context context, int wordCount, int correctWordCount, Word word, CallBackTestString callBackTestString) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("테스트");
        builder.setMessage(String.valueOf(correctWordCount)+ "/"+String.valueOf(wordCount));
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_for_test_view, null);
        TextView tv = view.findViewById(R.id.tv_korean);
        tv.setText(word.korean);
        EditText et = view.findViewById(R.id.et_english);
        builder.setView(view);
        builder.setNegativeButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(!et.getText().toString().isEmpty()) {
                    callBackTestString.callback(et.getText().toString().trim());
                } else {
                    Toast.makeText(context, "적어주세요", Toast.LENGTH_SHORT).show();
                    getTestDialog(context, wordCount, correctWordCount, word, callBackTestString).show();
                }
            }
        });
        return builder.create();
    }
}
