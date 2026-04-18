package ru.vafeen.api

import androidx.fragment.app.Fragment

interface TestProvider {
    fun getTestFragment(testDependencies: TestDependencies): Fragment
}