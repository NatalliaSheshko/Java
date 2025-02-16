package com.itproger;

import javax.swing.*;//автоматически импортируется библиотека после создания класса JFrame, позволяет создать полностью само приложение
import java.awt.*;//библиотека, которая позволяет создавать объекты внутри приложения (кнопки, надписи, контейнеры и т.д.)
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame {

    JTextField name_field, email_field;//выношу создание полей из конструктора, чтобы они были видны для класса ButtonEventManager

    JRadioButton male, female;

    JCheckBox check;

    //JFrame - основной класс в javax.swing
    public ContactForm(){
        super("Контактная форма");//передаю в конструктор title (название приложения)
        super.setBounds(200,100, 300, 230);//указываю месторасположение на UI - 200 и 100 от верхнего левого угла
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//при закрытии приложения (нажатии на крестик), само приложение тоже закроется
        //создаю контейнер, внутрь которого сможем забрасывать различные объекты:
        Container container = super.getContentPane();//чтобы импортировать библиотеку для этого метода, нужно выделить слово Container и нажать alt+enter
        container.setLayout(new GridLayout(5, 2, 2, 10));//указываю, какую систему раположения будем успользовать - систему сеток

        JLabel name = new JLabel("Введите имя: ");//объект для создания надписи
        name_field = new JTextField("", 1);//поле, в которое пользователь сможет вводить данные
        JLabel email = new JLabel("Введите email: ");
        email_field = new JTextField("@", 1);

        container.add(name);//добавляю объект в приложение
        container.add(name_field);
        container.add(email);
        container.add(email_field);

        male = new JRadioButton("Мужской");//устанавливаю значение для радио-баттона
        female = new JRadioButton("Женский");

        check = new JCheckBox("Согласен?", false);//создаю чек-бокс

        JButton send_button = new JButton("Отправить");//создаю кнопку

        male.setSelected(true);//изначально будет выбран мужской пол
        container.add(male);
        container.add(female);
        //чтобы радиокнопки работали в связке:
        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        container.add(check);
        container.add(send_button);

        //создаю обработчик события через метод addActionListener:
        send_button.addActionListener(new ButtonEventManager());





    }
    class ButtonEventManager implements ActionListener { //внутри класса ButtonEventManager реализовываю интерфейс ActionListener

        @Override
        public void actionPerformed(ActionEvent e) {
             //здесь прописываю, что будет происходить при нажатии на кнопку:
            String name = name_field.getText();//получаю значение из поля name_field и записываю в переменную name
            String email = email_field.getText();

            String isMale = "Мужской";
            if(!male.isSelected())//проверяю, выбран ли Мужской, если не выбран, то записываю другой вариант (Женский) в эту переменную
                isMale ="Женский";

            boolean checkBox = check.isSelected();//получаю значение из поля check и записываю в checkBox

            //вывожу данные в сплывающем окне:
            JOptionPane.showMessageDialog(null, "Ваша почта: " + email +
                    "\nВаш пол: " + isMale + "\nВы согласны?" + checkBox, "Привет, " +
                    name, JOptionPane.PLAIN_MESSAGE); //JOptionPane - всплывающее окно





        }
    }
}
