package edu.ni.abra.intent

sealed class Intent {
    object GetCatEvent:Intent()
    object None:Intent()
}