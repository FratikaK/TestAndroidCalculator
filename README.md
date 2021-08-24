# TestAndroidCalculator

簡単な整数の四則演算ができるサンプルです

## 機能
* 整数の四則演算
* 何らかのエラーが発生した場合にダイアログを表示する

## 計算の仕組み
1. 一項目の数字を入力  
2. 四則演算子を入力すると第二項目の数字が入力できるようになる  
3. 第二項目を入力後、RESULTボタンを押すことで計算結果が表示される

### 四則演算のコード  
```kotlin
        fun calcCation(firstStr: String, secondStr: String, calc: String): String {
            if (calc == "/" || calc == "*" || calc == "-" || calc == "+") {
                try {
                    val firstNum = Integer.parseInt(firstStr)
                    val secondNum = Integer.parseInt(secondStr)
                    when (calc) {
                        "/" -> {
                            return "${firstNum / secondNum}"
                        }
                        "*" -> {
                            return "${firstNum * secondNum}"
                        }
                        "-" -> {
                            return "${firstNum - secondNum}"
                        }
                        "+" -> {
                            return "${firstNum + secondNum}"
                        }
                    }
                } catch (e: NumberFormatException) {
                    //エラーダイアログを表示
                } catch (e: ArithmeticException) {
                    //エラーダイアログを表示
                }
            }
            return "Error"
        }
```  
String型をInteger型に変換し、計算。計算結果をまたString型に変換して返します  
