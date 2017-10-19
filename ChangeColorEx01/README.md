# Color Change Dialog box 


In this project we are using external ![dependancy](https://github.com/ItsPriyesh/chroma) for our project

A simple, lightweight color picker for Android written in Kotlin (interoperable with Java).

<img src="https://raw.githubusercontent.com/ItsPriyesh/chroma/master/art/red.png" width="250">
<img src="https://raw.githubusercontent.com/ItsPriyesh/chroma/master/art/green.png" width="250">
<img src="https://raw.githubusercontent.com/ItsPriyesh/chroma/master/art/blue.png" width="250">


Add the following dependency to your projects `build.gradle`:
``` groovy
compile 'me.priyesh:chroma:1.0.2'
```

Usage
-----
To display a color picker `DialogFragment`:

``` kotlin
private fun showColorPickerDialog() {
        ChromaDialog.Builder()
                .initialColor(Color.BLUE)
                .colorMode(ColorMode.RGB)
                .onColorSelected(object : ColorSelectListener {
                    override fun onColorSelected(color: Int) {
                       Toast.makeText(applicationContext,"Color is = "+color,Toast.LENGTH_SHORT).show()
                    }
                })
                .create()
                .show(supportFragmentManager, "dialog")
    }

```


These imports may be required

``` kotlin
import me.priyesh.chroma.ChromaDialog;
import me.priyesh.chroma.ColorMode;
import me.priyesh.chroma.ColorSelectListener;
``` 
