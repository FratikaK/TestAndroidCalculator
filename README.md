# TestAndroidCalculator

簡単な整数の四則演算ができるサンプルです

## 確認済みの動作環境  
* Java 11
* Kotlin 1.5.21
* Pixel 4 API 30
* System Image R

## 機能
* 整数の四則演算
* 何らかのエラーが発生した場合にダイアログを表示する

## 計算の仕組み
1. 一項目の数字を入力  
2. 四則演算子を入力すると第二項目の数字が入力できるようになる  
3. 第二項目を入力後、RESULTボタンを押すことで計算結果が表示される

## 画像サンプル  
#### 初期画面
![Screenshot_1629802754](https://user-images.githubusercontent.com/74973509/130611414-28d3e9d5-fc3b-47f1-bf06-aa4238ea8b83.png)
#### エラーダイアログの表示
![Screenshot_1629805779](https://user-images.githubusercontent.com/74973509/130611550-0528c801-e141-49eb-92c9-0ccc14a9a735.png)
![Screenshot_1629805786](https://user-images.githubusercontent.com/74973509/130611590-efdb7113-5577-4cb3-ac61-40c9d6d1d84d.png)


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
桁数が大きすぎるか、0で割った場合にエラーダイアログを表示させます
