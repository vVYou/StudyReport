package studyreport.fodmap;

import java.util.HashMap;
import java.util.Map;

public class FodmapAnswer {

	private final String studyId;
	private final Map<FodmapCSVDescription, Integer> answers = new HashMap<>();

	public FodmapAnswer(String studyId) {
		this.studyId = studyId;
	}

	public String getStudyId() {
		return studyId;
	}

	public Integer addAnswer(FodmapCSVDescription description, int answer) {
		return answers.put(description, answer);
	}

	public Map<FodmapCSVDescription, Integer> getAnswers() {
		return answers;
	}
}
