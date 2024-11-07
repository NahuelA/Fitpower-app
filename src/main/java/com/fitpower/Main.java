package com.fitpower;

import com.fitpower.repository.Conexion;
import com.fitpower.view.JFrameLogin;

public class Main {
    public static void main(String[] args) {
        new Conexion();
        JFrameLogin login = new JFrameLogin();
    }
}