package Calculator;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Display extends javax.swing.JFrame {

    /**
     * @author Pavel Bobčík, xbobci03
     * @author tomalatomas, xtomal02
     */
    public Display() {
        initComponents();
        this.setTitle("OAGUH Calculator");
    }

    private int getOperatorPriority(char operator) {
        switch (operator) {
            case '!':
                return 1;
            case '/':
                return 2;
            case '*':
                return 2;
            case '+':
                return 3;
            case '-':
                return 3;
            default:
                return 0;
        }
    }

    private ArrayList<Integer> findFactorials(String equation) {
        ArrayList<Integer> operatorsFactorial = new ArrayList<Integer>();
        for (int i = 0; i < equation.length(); i++) {
            char o = equation.charAt(i);
            if (this.getOperatorPriority(o) != 0) {
                switch (this.getOperatorPriority(o)) {
                    case 1:
                        operatorsFactorial.add(i);
                        System.out.println("Factorial, index:" + i + ",Number before:" + getStringNumberBeforeOper(equation, i));
                }
            }
        }
        return operatorsFactorial;
    }

    private ArrayList<Integer> findOperators(String equation) {
        ArrayList<Integer> operatorsPriorityTwo = new ArrayList<Integer>();
        ArrayList<Integer> operatorsPriorityThree = new ArrayList<Integer>();
        //To do: searching through string anf find all operators
        //Store them into the arraylist by their priority
        for (int i = 0; i < equation.length(); i++) {
            char o = equation.charAt(i);
            if (this.getOperatorPriority(o) != 0) {
                switch (this.getOperatorPriority(o)) {
                    case 2:
                        operatorsPriorityTwo.add(i);
                        System.out.println("Operator:'" + o + "', index:" + i + ",Number before:" + getStringNumberBeforeOper(equation, i)
                                + ",Number after:" + getStringNumberAfterOper(equation, i));
                        break;
                    case 3:
                        operatorsPriorityThree.add(i);
                        break;
                }
            }
        }
        ArrayList<Integer> operatorsPriorityTwoThree = new ArrayList<>();
        operatorsPriorityTwoThree.addAll(operatorsPriorityTwo);
        operatorsPriorityTwoThree.addAll(operatorsPriorityThree);
        return operatorsPriorityTwoThree;

    }

    private boolean checkDoubleOperators(String equation) {
        for (int i = 0; i < equation.length() - 1; i++) {
            if (equation.charAt(i) == equation.charAt(i + 1)) {
                return true;
            }
        }
        return false;

    }

    public boolean checkInvalidChars(String equation) {
        final String validChars = "0123456789+-*/!,";
        for (int i = 0; i < equation.length(); i++) {
            if (!validChars.contains(Character.toString(equation.charAt(i)))) {
                return true;
            }
        }
        return false;
    }

    private String getStringNumberBeforeOper(String equation, int operIndex) {
        String number = "";
        for (int i = operIndex-1; i >= 0; i--) {
            if (getOperatorPriority(equation.charAt(i)) == 0) {
                number = equation.charAt(i) + number;
            } else {
                return number;
            }
        }
        return number;
    }

    private String getStringNumberAfterOper(String equation, int operIndex) {
        String number = "";
        for (int i = operIndex+1; i < equation.length(); i++) {
            if (getOperatorPriority(equation.charAt(i)) == 0) {
                number = number + equation.charAt(i);
            } else {
                return number;
            }
        }
        return number;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnTwo = new javax.swing.JButton();
        btnThree = new javax.swing.JButton();
        btnDivision = new javax.swing.JButton();
        btnDeleteAll = new javax.swing.JButton();
        btnOne = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnFive = new javax.swing.JButton();
        btnSix = new javax.swing.JButton();
        btnTimes = new javax.swing.JButton();
        btnDeleteLast = new javax.swing.JButton();
        btnFour = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnEight = new javax.swing.JButton();
        btnNine = new javax.swing.JButton();
        btnPlus = new javax.swing.JButton();
        btnFact = new javax.swing.JButton();
        btnSeven = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnZero = new javax.swing.JButton();
        btnEquals = new javax.swing.JButton();
        btnMinus = new javax.swing.JButton();
        btnABS = new javax.swing.JButton();
        btnDot = new javax.swing.JButton();
        tvDisplay = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnTwo.setBackground(new java.awt.Color(75, 75, 75));
        btnTwo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnTwo.setForeground(new java.awt.Color(240, 240, 240));
        btnTwo.setText("2");
        btnTwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTwoActionPerformed(evt);
            }
        });

        btnThree.setBackground(new java.awt.Color(75, 75, 75));
        btnThree.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnThree.setForeground(new java.awt.Color(240, 240, 240));
        btnThree.setText("3");
        btnThree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThreeActionPerformed(evt);
            }
        });

        btnDivision.setBackground(new java.awt.Color(0, 0, 0));
        btnDivision.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDivision.setForeground(new java.awt.Color(240, 240, 240));
        btnDivision.setText("/");
        btnDivision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDivisionActionPerformed(evt);
            }
        });

        btnDeleteAll.setBackground(new java.awt.Color(0, 0, 0));
        btnDeleteAll.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDeleteAll.setForeground(new java.awt.Color(230, 76, 0));
        btnDeleteAll.setText("CE");
        btnDeleteAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAllActionPerformed(evt);
            }
        });

        btnOne.setBackground(new java.awt.Color(75, 75, 75));
        btnOne.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnOne.setForeground(new java.awt.Color(240, 240, 240));
        btnOne.setText("1");
        btnOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOne, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThree, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDivision, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeleteAll, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOne, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThree, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDivision, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteAll, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnFive.setBackground(new java.awt.Color(75, 75, 75));
        btnFive.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnFive.setForeground(new java.awt.Color(240, 240, 240));
        btnFive.setText("5");
        btnFive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiveActionPerformed(evt);
            }
        });

        btnSix.setBackground(new java.awt.Color(75, 75, 75));
        btnSix.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSix.setForeground(new java.awt.Color(240, 240, 240));
        btnSix.setText("6");
        btnSix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSixActionPerformed(evt);
            }
        });

        btnTimes.setBackground(new java.awt.Color(0, 0, 0));
        btnTimes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnTimes.setForeground(new java.awt.Color(240, 240, 240));
        btnTimes.setText("*");
        btnTimes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimesActionPerformed(evt);
            }
        });

        btnDeleteLast.setBackground(new java.awt.Color(0, 0, 0));
        btnDeleteLast.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDeleteLast.setForeground(new java.awt.Color(230, 76, 0));
        btnDeleteLast.setText("C");
        btnDeleteLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteLastActionPerformed(evt);
            }
        });

        btnFour.setBackground(new java.awt.Color(75, 75, 75));
        btnFour.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnFour.setForeground(new java.awt.Color(240, 240, 240));
        btnFour.setText("4");
        btnFour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFourActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFour, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFive, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSix, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimes, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeleteLast, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFour, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFive, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSix, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteLast, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnEight.setBackground(new java.awt.Color(75, 75, 75));
        btnEight.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEight.setForeground(new java.awt.Color(240, 240, 240));
        btnEight.setText("8");
        btnEight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEightActionPerformed(evt);
            }
        });

        btnNine.setBackground(new java.awt.Color(75, 75, 75));
        btnNine.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNine.setForeground(new java.awt.Color(240, 240, 240));
        btnNine.setText("9");
        btnNine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNineActionPerformed(evt);
            }
        });

        btnPlus.setBackground(new java.awt.Color(0, 0, 0));
        btnPlus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnPlus.setForeground(new java.awt.Color(240, 240, 240));
        btnPlus.setText("+");
        btnPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlusActionPerformed(evt);
            }
        });

        btnFact.setBackground(new java.awt.Color(0, 0, 0));
        btnFact.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnFact.setForeground(new java.awt.Color(240, 240, 240));
        btnFact.setText("!");
        btnFact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFactActionPerformed(evt);
            }
        });

        btnSeven.setBackground(new java.awt.Color(75, 75, 75));
        btnSeven.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSeven.setForeground(new java.awt.Color(240, 240, 240));
        btnSeven.setText("7");
        btnSeven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSevenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEight, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNine, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFact, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEight, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNine, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFact, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnZero.setBackground(new java.awt.Color(75, 75, 75));
        btnZero.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnZero.setForeground(new java.awt.Color(240, 240, 240));
        btnZero.setText("0");
        btnZero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZeroActionPerformed(evt);
            }
        });

        btnEquals.setBackground(new java.awt.Color(0, 0, 0));
        btnEquals.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEquals.setForeground(new java.awt.Color(240, 240, 240));
        btnEquals.setText("=");
        btnEquals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEqualsActionPerformed(evt);
            }
        });

        btnMinus.setBackground(new java.awt.Color(0, 0, 0));
        btnMinus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnMinus.setForeground(new java.awt.Color(240, 240, 240));
        btnMinus.setText("-");
        btnMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinusActionPerformed(evt);
            }
        });

        btnABS.setBackground(new java.awt.Color(0, 0, 0));
        btnABS.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnABS.setForeground(new java.awt.Color(240, 240, 240));
        btnABS.setText("ABS");
        btnABS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnABSActionPerformed(evt);
            }
        });

        btnDot.setBackground(new java.awt.Color(0, 0, 0));
        btnDot.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDot.setForeground(new java.awt.Color(240, 240, 240));
        btnDot.setText(",");
        btnDot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDot, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnZero, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEquals, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnABS, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDot, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnZero, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEquals, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnABS, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tvDisplay.setEditable(false);
        tvDisplay.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tvDisplay.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tvDisplay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tvDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAllActionPerformed
        tvDisplay.setText("");
    }//GEN-LAST:event_btnDeleteAllActionPerformed

    private void btnDeleteLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteLastActionPerformed
        if(tvDisplay.getText().length()!=0){
            tvDisplay.setText("" + tvDisplay.getText().substring(0, tvDisplay.getText().length() - 1));
        }
    }//GEN-LAST:event_btnDeleteLastActionPerformed

    private void btnFiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiveActionPerformed
        tvDisplay.setText(tvDisplay.getText() + "5");
    }//GEN-LAST:event_btnFiveActionPerformed

    private void btnEightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEightActionPerformed
        tvDisplay.setText(tvDisplay.getText() + "8");
    }//GEN-LAST:event_btnEightActionPerformed

    private void btnFactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFactActionPerformed
        tvDisplay.setText(tvDisplay.getText() + "!");
    }//GEN-LAST:event_btnFactActionPerformed

    private void btnPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlusActionPerformed
        tvDisplay.setText(tvDisplay.getText() + "+");
    }//GEN-LAST:event_btnPlusActionPerformed

    private void btnZeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZeroActionPerformed
        tvDisplay.setText(tvDisplay.getText() + "0");
    }//GEN-LAST:event_btnZeroActionPerformed

    private void btnMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinusActionPerformed
        tvDisplay.setText(tvDisplay.getText() + "-");
    }//GEN-LAST:event_btnMinusActionPerformed

    private void btnABSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnABSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnABSActionPerformed

    private void btnOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOneActionPerformed
        tvDisplay.setText(tvDisplay.getText() + "1");
    }//GEN-LAST:event_btnOneActionPerformed

    private void btnTwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTwoActionPerformed
        tvDisplay.setText(tvDisplay.getText() + "2");
    }//GEN-LAST:event_btnTwoActionPerformed

    private void btnThreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThreeActionPerformed
        tvDisplay.setText(tvDisplay.getText() + "3");
    }//GEN-LAST:event_btnThreeActionPerformed

    private void btnFourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFourActionPerformed
        tvDisplay.setText(tvDisplay.getText() + "4");
    }//GEN-LAST:event_btnFourActionPerformed

    private void btnSixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSixActionPerformed
        tvDisplay.setText(tvDisplay.getText() + "6");
    }//GEN-LAST:event_btnSixActionPerformed

    private void btnSevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSevenActionPerformed
        tvDisplay.setText(tvDisplay.getText() + "7");
    }//GEN-LAST:event_btnSevenActionPerformed

    private void btnNineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNineActionPerformed
        tvDisplay.setText(tvDisplay.getText() + "9");
    }//GEN-LAST:event_btnNineActionPerformed

    private void btnDotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDotActionPerformed
        tvDisplay.setText(tvDisplay.getText() + ",");
    }//GEN-LAST:event_btnDotActionPerformed

    private void btnTimesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimesActionPerformed
        tvDisplay.setText(tvDisplay.getText() + "*");

    }//GEN-LAST:event_btnTimesActionPerformed

    private void btnDivisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDivisionActionPerformed
        tvDisplay.setText(tvDisplay.getText() + "/");

    }//GEN-LAST:event_btnDivisionActionPerformed

    private void btnEqualsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEqualsActionPerformed
        String equation = tvDisplay.getText();
        if (checkDoubleOperators(equation)) {
            tvDisplay.setText("Error:Stacked operators");
        } else if (checkInvalidChars(equation)) {
            tvDisplay.setText("Error:Invalid characters");
        }
        findFactorials(equation);
        findOperators(equation);


    }//GEN-LAST:event_btnEqualsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Display().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnABS;
    private javax.swing.JButton btnDeleteAll;
    private javax.swing.JButton btnDeleteLast;
    private javax.swing.JButton btnDivision;
    private javax.swing.JButton btnDot;
    private javax.swing.JButton btnEight;
    private javax.swing.JButton btnEquals;
    private javax.swing.JButton btnFact;
    private javax.swing.JButton btnFive;
    private javax.swing.JButton btnFour;
    private javax.swing.JButton btnMinus;
    private javax.swing.JButton btnNine;
    private javax.swing.JButton btnOne;
    private javax.swing.JButton btnPlus;
    private javax.swing.JButton btnSeven;
    private javax.swing.JButton btnSix;
    private javax.swing.JButton btnThree;
    private javax.swing.JButton btnTimes;
    private javax.swing.JButton btnTwo;
    private javax.swing.JButton btnZero;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField tvDisplay;
    // End of variables declaration//GEN-END:variables
}
