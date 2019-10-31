package com.trustev.domain.entities;

import java.util.List;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.function.Function;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Decision<T extends Decision> extends TimestampBase<T> {

    /*
     * The Trustev Comment that Trustev has added to this Decision.
     */
    private String comment;

    /*
     * A Trustev Confidence Score represents our confidence on a Trustev Decision based on the level of details supplied within a Trustev Case.
     * The Trustev Confidence Score is out of 100. 100 being all information was supplied and validated and 0 indicating that no information was contained within the Trustev Case.
     */
    private int confidence;

    /*
     * The Result of the Trustev Decision.
     */
    private DecisionResult result;

    /*
     * This is the score that Trustev assigned the Case. This can be ignored.
     */
    private int score;

    /*
     * The SessionId of the Case that this Decision was based on
     */
    private UUID sessionId;
    int type;
    String version;

    @JsonProperty("Comment")
    public String getComment() {
        return comment;
    }

    public void setComment(final String value) {
        this.comment = value;
    }

    @JsonProperty("Confidence")
    public int getConfidence() {
        return confidence;
    }

    public void setConfidence(final int value) {
        this.confidence = value;
    }

    @JsonProperty("Result")
    public DecisionResult getResult() {
        return result;
    }

    public void setResult(final DecisionResult value) {
        this.result = value;
    }

    @JsonProperty("Score")
    public int getScore() {
        return score;
    }

    public void setScore(final int value) {
        this.score = value;
    }

    @JsonProperty("SessionId")
    public UUID getSessionId() {
        return sessionId;
    }

    public void setSessionId(final UUID value) {
        this.sessionId = value;
    }

    @JsonProperty("Type")
    public int getType() {
        return type;
    }

    public void setType(final int value) {
        this.type = value;
    }

    @JsonProperty("Version")
    public String getVersion() {
        return version;
    }

    public void setVersion(final String value) {
        this.version = value;
    }

    @Override
    protected void buildSignificationProperties(List<Function<T, Comparable>> props) {
        props.add(T::getComment);
        props.add(T::getConfidence);
        props.add(T::getResult);
        props.add(T::getScore);
        props.add(T::getSessionId);
        props.add(T::getType);
        props.add(T::getVersion);
        super.buildSignificationProperties(props);
    }
}
