package com.commands;

import java.util.Scanner;

public interface Command {

    void execute();

    Scanner scanner = new Scanner(System.in);
}
