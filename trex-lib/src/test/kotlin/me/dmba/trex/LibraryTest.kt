package me.dmba.trex

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class LibraryTest {

    @Test
    fun testMyLanguage() {
        // Given
        val classUnderTest = Library()

        // When
        val language = classUnderTest.kotlinLanguage()

        // Then
        assertThat(language).isNotNull()
        assertThat(language.name).isEqualTo("Kotlin")
        assertThat(language.hotness).isEqualTo(10)
    }

}
