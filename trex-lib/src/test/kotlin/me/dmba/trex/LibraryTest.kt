package me.dmba.trex

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class LibraryTest {

    @Test
    fun `test some library method`() {
        // Given
        val classUnderTest = Library()

        // When
        val result = classUnderTest.someLibraryMethod()

        // Then
        assertThat(result).isTrue()
    }

}
