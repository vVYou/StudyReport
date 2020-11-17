package studyreport.fodmap;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.CompareToBuilder;

public class FodmapAnswer implements Comparable<FodmapAnswer> {

	private final int studyId;
	private final Map<FodmapCSVDescription, Integer> answers = new HashMap<>();

	public FodmapAnswer(int studyId) {
		this.studyId = studyId;
	}

	public int getStudyId() {
		return studyId;
	}

	public Integer addAnswer(FodmapCSVDescription description, int answer) {
		return answers.put(description, answer);
	}

	public Map<FodmapCSVDescription, Integer> getAnswers() {
		return answers;
	}

	@Override
	public int compareTo(FodmapAnswer fodmapAnswer) {
		return new CompareToBuilder()
				.append(studyId, fodmapAnswer.getStudyId())
				.toComparison();
	}
}
