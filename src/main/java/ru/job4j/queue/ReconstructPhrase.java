package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;
    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder text = new StringBuilder();
        int size = evenElements.size();
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                text.append(evenElements.pollFirst());
            } else {
                evenElements.pollFirst();
            }
        }
        return text.toString();
    }

    private String getDescendingElements() {
        StringBuilder text = new StringBuilder();
        int size = descendingElements.size();
        for (int i = 0; i < size; i++) {
            text.append(descendingElements.pollLast());
        }
        return text.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
