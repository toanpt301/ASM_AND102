package com.example.ps37329_asm_and102;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ps37329_asm_and102.dao.NguoiDungDAO;

public class RegisterActivity extends AppCompatActivity {
    private NguoiDungDAO nguoiDungDAO;
    EditText edtUser, edtPass, edtRePass, edtFullname;
    Button btnSignup, btnGoback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);
        edtRePass = findViewById(R.id.edtRePass);
        edtFullname = findViewById(R.id.edtFullname);
        btnSignup = findViewById(R.id.btnSignup);
        btnGoback = findViewById(R.id.btnGoback);

        nguoiDungDAO = new NguoiDungDAO(this);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUser.getText().toString();
                String pass = edtPass.getText().toString();
                String rePass = edtRePass.getText().toString();
                String fullname = edtFullname.getText().toString();

                if (!pass.equals(rePass)){
                    Toast.makeText(RegisterActivity.this, "Nhập 2 mật khẩu trùng nhau. Kiểm tra lại!", Toast.LENGTH_SHORT).show();
                } else {
                    boolean check = nguoiDungDAO.Register(user, pass, fullname);
                    if (check){
                        Toast.makeText(RegisterActivity.this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(RegisterActivity.this, "Đăng ký thất bại. Kiểm tra lại!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnGoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}