package com.wons.englishwordmanager.english_setting.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.wons.englishwordmanager.R;

import java.util.HashMap;

public class SettingDialogs {
    public AlertDialog getDialogForReplaceOrDelete(Context context, SettingDialogCallBack callBack) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("수정 및 삭제");
        builder.setMessage("수정 또는 삭제하시겠습니까?");
        builder.setPositiveButton("수정", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                callBack.callback_code(SettingEnum.REPLACE);
            }
        });
        builder.setNegativeButton("삭제", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                callBack.callback_code(SettingEnum.DELETE);
            }
        });
        builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        return builder.create();
    }

    public AlertDialog getAlertDialogForAddWord(Context context, SettingCallBackForWord callback) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("추가할 단어를 적어주세요");
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_view_for_add_word, null);
        EditText et_inputEnglish, et_inputKorean;
        et_inputEnglish = view.findViewById(R.id.et_inputEnglish);
        et_inputKorean = view.findViewById(R.id.et_inputKorean);
        builder.setView(view);
        builder.setPositiveButton("추가", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if ((!et_inputEnglish.getText().toString().isEmpty()) && (!et_inputKorean.getText().toString().isEmpty())) {
                    HashMap<WordEnum, String> map = new HashMap<>();
                    map.put(WordEnum.KOREAN, et_inputKorean.getText().toString().trim());
                    map.put(WordEnum.ENGLISH, et_inputEnglish.getText().toString().trim());
                    callback.callback(map);
                } else {
                    Toast.makeText(context, "항목을 제대로 적어주세요", Toast.LENGTH_SHORT).show();
                    getAlertDialogForAddWord(context, callback).show();
                }
            }
        });
        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        return builder.create();
    }

    public AlertDialog getDialogForAddList(Context context, SettingCallBackString callBackString) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_view_for_replace_title, null);
        EditText et_title = view.findViewById(R.id.et_replace);
        builder.setTitle("리스트 추가");
        et_title.setHint("리스트의 이름을 적어주세요");
        builder.setView(view);
        builder.setPositiveButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setNegativeButton("추가", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (!et_title.getText().toString().isEmpty()) {
                    callBackString.callback(et_title.getText().toString().trim());
                } else {
                    Toast.makeText(context, "이름을 적어주세요", Toast.LENGTH_SHORT).show();
                    getDialogForAddList(context, callBackString).show();
                }
            }
        });
        return builder.create();
    }

}
