package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sumOfScore = 0D;
        for (Label label : averageScoreByPupil(pupils)) {
            sumOfScore += label.score();
        }
        return sumOfScore / averageScoreByPupil(pupils).size();
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        double sumOfScore;
        List<Label> averageScoreByPupilList = new ArrayList<>();
        for (Pupil pupil : pupils) {
            sumOfScore = 0D;
            for (Subject subject : pupil.subjects()) {
                sumOfScore += subject.score();
            }
            averageScoreByPupilList.add(new Label(pupil.name(), sumOfScore / pupil.subjects().size()));
        }
        return averageScoreByPupilList;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        Map<String, Integer> averageBySubjectMap = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                averageBySubjectMap.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        for (Map.Entry<String, Integer> entry : averageBySubjectMap.entrySet()) {
            rsl.add(new Label(entry.getKey(), (double) entry.getValue() / pupils.size()));
        }
        return rsl;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        int sum;
        List<Label> scoreList = new ArrayList<>();
        for (Pupil pupil : pupils) {
            sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            scoreList.add(new Label(pupil.name(), sum));
        }
        scoreList.sort(Comparator.naturalOrder());
        return scoreList.get(scoreList.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        Map<String, Integer> sumScoreMap = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumScoreMap.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        for (Map.Entry<String, Integer> entry : sumScoreMap.entrySet()) {
            rsl.add(new Label(entry.getKey(), entry.getValue()));
        }
        rsl.sort(Comparator.naturalOrder());
        return rsl.get(rsl.size() - 1);
    }
}
