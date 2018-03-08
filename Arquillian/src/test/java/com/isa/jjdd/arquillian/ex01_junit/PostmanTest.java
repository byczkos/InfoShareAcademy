package com.isa.jjdd.arquillian.ex01_junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PostmanTest {

    @Mock
    private PostOffice postOffice;

    @InjectMocks
    Postman sut = new Postman();

    @Test
    public void shouldHaveNoLetterWhenEmptyPostBag() throws Exception {
        // given
        sut.setPostBag(Collections.emptySet());

        // when
        Optional<Letter> nextLetter = sut.findNextLetter(Optional.empty());

        // then
        assertThat(nextLetter).isEmpty();
    }

    @Test
    public void shouldTakeTheLetterWhenPostBagHasOnlyOne() throws Exception {
        // given
        Letter singleLetter = new Letter();
        sut.setPostBag(Stream.of(singleLetter)
                .collect(Collectors.toSet()));

        assertThat(sut.getPostBag()).hasSize(1);
        assertThat(sut.getPostBag()).containsExactly(singleLetter);

        // when
        Optional<Letter> nextLetter = sut.findNextLetter(Optional.empty());

        // then
        assertThat(nextLetter).isNotEmpty();
        assertThat(nextLetter.get()).isEqualTo(singleLetter);

    }

    @Test
    public void shouldPostBagBeEmptyWhenLastLetterHasBeenTaken() throws Exception {
        // given
        Set<Letter> postBag = Stream.of(new Letter()).collect(Collectors.toSet());
        sut.setPostBag(postBag);

        // when
        sut.findNextLetter(Optional.empty());

        // then
        assertThat(sut.getPostBag()).isEmpty();
    }

    @Test
    public void shouldTakeLettersFromPostOfficeOnceADay() throws Exception {
        // given
        Set<Letter> fakePostBag = Stream.of(
                createTestLetter(Envelope.A5),
                createTestLetter(Envelope.C5)
        ).collect(Collectors.toSet());
        when(postOffice.preparePostBag()).thenReturn(fakePostBag);

        // when
        sut.beginNewDay();

        // then
        verify(postOffice, times(1)).preparePostBag();
        assertThat(sut.getPostBag()).hasSize(2);
        assertThat(sut.getPostBag()).containsExactlyElementsOf(fakePostBag);

    }

    private Letter createTestLetter(Envelope envelope) {
        return new Letter(
                generateTestAddress("Sender"),
                generateTestAddress("Receiver"), envelope);
    }

    private Address generateTestAddress(String direction) {
        return new Address("test" + direction +"City", "test" + direction +"Street", "15", "5");
    }
}