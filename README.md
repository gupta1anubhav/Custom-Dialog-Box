# CustomDialogBox [![Platform](https://img.shields.io/badge/Platform-Android-green.svg) ]() [![](https://jitpack.io/v/gupta1anubhav/Custom-Dialog-Box.svg)](https://jitpack.io/#gupta1anubhav/Custom-Dialog-Box) [![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT) [![Build Status](https://img.shields.io/teamcity/codebetter/bt428.svg)]()

Simple and easy Android Dialog by gupta1anubhav

![Sample Video](https://thumbs.gfycat.com/PowerlessTameCassowary-size_restricted.gif)

---
# Sample.apk
You can download the latest sample APK from this repo here: https://github.com/gupta1anubhav/CustomDialog/blob/master/sample/sample.apk

---
### Import to your project
add below code in `build.gradle (Module: app)`
```gradle
dependencies {
  // ... other dependencies here
    implementation 'com.github.gupta1anubhav:Custom-Dialog-Box:v1.0'
}
```
---

### CustomDialogBox - Basic

```java
new CustomDialog.Builder(thisActivity)
          .setTitle("Hello !")
          .setContent("This is basic CustomDialog :)", 3)

          // Customizing (You can find more in Wiki)

          //.setBtnConfirmText("Check!")
          //.setBtnConfirmTextColor("#de413e")
          //.setBtnCancelText("Cancel")
          //.setBtnCancelTextColor("#de413e")
          //.setCancelable(true)          // Default value is false
          //.onConfirm(new CustomDialog.BtnCallback() {
          //    @Override
          //    public void onClick(@NonNull CustomDialog dialog, @NonNull CustomDialog.BtnAction which) {
          //        // Do something
          //    }
          //})
          //.setBtnCancelText("Cancel", false)
          //.onCancel(new CustomDialog.BtnCallback() {
          //    @Override
          //    public void onClick(@NonNull CustomDialog dialog, @NonNull CustomDialog.BtnAction which) {
          //        // Do something
          //    }
          //})
          .show();    // Must be called at the end
```


### CustomDialogBox - Progress

###### [Want to make custom GIF?](https://loading.io/)
(Don't forget to save it in `res/raw`)
```java
new CustomDialog.Builder(thisActivity)
          .setContent("This is progress CustomDialog :)", 7)
          // .showProgress must be set true if you want ProgressDialog
          .showProgress(true)     // Default GIF is in the library (R.raw.simple_dialog_progress_default)
          //.setProgressGIF(R.raw.simple_dialog_progress_default)
          .setBtnCancelText("Cancel")
          .setBtnCancelTextColor("#2861b0")

          // Customizing (You can find more in Wiki)

          //.setBtnCancelText("Cancel", false)
          //.setBtnCancelTextColor(R.color.colorPrimary)
          //.setBtnCancelShowTime(2000)
          //.onCancel(new CustomDialog.BtnCallback() {
          //    @Override
          //    public void onClick(@NonNull CustomDialog dialog, @NonNull CustomDialog.BtnAction which) {
          //        // thisActivity.finish();
          //    }
          //})
          //.showProgress(true)
          .show();    // Must be called at the end
```


### CustomDialogBox - Guide

```java
new CustomDialog.Builder(thisActivity)
          .setTitle("Hello !", true)
          .setContent("This is guide CustomDialog :)\n\n- You can pinch the view !")
          .setGuideImage(R.drawable.image_guide_pinch)
          .setGuideImageSizeDp(150, 150)
          .setPermanentCheck(Pref.PREFERENCE_NAME, Pref.KEY_FIRST_WELCOME)
          .onConfirm(new CustomDialog.BtnCallbackWithPermanentCheck() {
              @Override
              public void onClick(@NonNull CustomDialog dialog, @NonNull CustomDialog.BtnAction which, boolean isPermanentChecked) {
                  if( isPermanentChecked )
                      setBtnGuideReset(true);
              }
          })
          .setBtnConfirmText("Check!")
          .setBtnConfirmTextColor("#e6b115")
          // I thought cancel button is not necessary, it's unavailable unless there're requests


          // Customizing (You can find more in Wiki)

          //.setTitle("Hello !", true)
          //.setBtnPermanentCheckText("다시 보지 않기", true)
          //.setGuideImagePaddingDp(10)
          //.setGuideImageSizeDp(100, 100)
          .showIfPermanentValueIsFalse();  // Must be called at the end (if permanentCheck is necessary)
```


### CustomDialogBox - CustomView

```java
new CustomDialog.Builder(thisActivity)
          .setTitle("This is Title :)")
          // If the customView is long enough, CustomDialog will put your layout in the ScrollView automatically
          .setCustomView(R.layout.gupta1anubhav_simple_dialog_test_layout_custom_long)
          .setBtnConfirmText("Check!")
          .setBtnConfirmTextSizeDp(16)
          .setBtnConfirmTextColor("#1fd1ab")
          .setBtnCancelText("Cancel", false)
          .setBtnCancelTextColor("#555555")
          .show();    // Must be called at the end
```
---

License
-------
```sh
   MIT License

   Copyright (c) 2018 Anubhav Gupta

   Permission is hereby granted, free of charge, to any person obtaining a copy
   of this software and associated documentation files (the "Software"), to deal
   in the Software without restriction, including without limitation the rights
   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
   copies of the Software, and to permit persons to whom the Software is
   furnished to do so, subject to the following conditions:

   The above copyright notice and this permission notice shall be included in all
   copies or substantial portions of the Software.

   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
   SOFTWARE.
```