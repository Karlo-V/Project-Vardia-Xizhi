package domain.MedicalCasse;

import domain.MedicalDoctor.User;
import foundation.Assert;

import java.util.*;

public class MedicalCase {

    private UUID caseId;
    // ID of a case, can not be null  and can not be changed after the setting


    private String title;
    // title of the case, can noy be null and an empty string

    private String description;
    // a short description. can noy be null and an empty string

    private User owner;
    // User who create the case, can not be null

    private Set<Tag> tags = new HashSet<>();
    // tag for a case, works like a keyword



    private List<ContentItem> contentItems = new ArrayList<>();
    // The whole content of the case, can contains string or media

    private Set<User> members = new HashSet<>();
    // this set contains all members, which means all the invited doctors

    private Map<Option, Integer> votingResults = new HashMap<>();
    // this map contains the options and the number of their voters

    private Option correctOption;
    // the right option, the doctor who has chosen this option will gain point.

    private boolean isResolved;
    // tells us if the case was resolved

    private Discussion discussion;
   // a disscusion where doctor are able to talk about the cas, not null

    public static MedicalCase createCase(String title, String description, User owner) {
        MedicalCase newCase = new MedicalCase();
        newCase.caseId = UUID.randomUUID();
        newCase.title = title;
        newCase.description = description;
        newCase.owner = owner;
        return newCase;


    }


    public UUID getCaseId() {
        return caseId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public User getOwner() {
        return owner;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public List<ContentItem> getContentItems() {
        return contentItems;
    }

    public Set<User> getMembers() {
        return members;
    }

    public Map<Option, Integer> getVotingResults() {
        return votingResults;
    }

    public Option getCorrectOption() {
        return correctOption;
    }

    public boolean isResolved() {
        return isResolved;
    }

    public Discussion getDiscussion() {
        return discussion;
    }

    public void setCaseId(UUID caseId) {
        this.caseId =  Assert.isNotNull(caseId , "caseId");
    }

    public void setTitle(String title) {
        this.title  = Assert.isNotNull(title , "title ");
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOwner(User owner) {
        this.owner = Assert.isNotNull(owner, "owner");
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public void setContentItems(List<ContentItem> contentItems) {
        this.contentItems = contentItems;
    }

    public void setMembers(Set<User> members) {
        this.members = Assert.isNotNull(members  , "member");
    }

    public void setVotingResults(Map<Option, Integer> votingResults) {
        this.votingResults = votingResults;
    }

    public void setCorrectOption(Option correctOption) {
        this.correctOption = Assert.isNotNull(correctOption , "correctOption ");
    }

    public void setResolved(boolean resolved) {
        isResolved = resolved;
    }

    public void setDiscussion(Discussion discussion) {
        this.discussion   = Assert.isNotNull(discussion , "discussion ");
    }

    public void setInitialOptions(List<Option> options) {
        for (Option option : options) {
            this.votingResults.put(option, 0);  // 初始票数为0
        }
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
    }


    public void addContentItem(ContentItem item) {
        this.contentItems.add(item);
    }


    public void addMember(User user) {
        this.members.add(user);
    }


    public void resolveCase() {
        if (!isResolved && correctOption != null && allVotesIn()) {
            owner.updateScore(1);
            isResolved = true;
            System.out.println("Case resolved and score incremented for owner: " + owner.getUsername());
        }
    }

    private boolean allVotesIn() {
        // 遍历votes字典中的每一个值
        for (Integer vote : votingResults.values()) {
            // 如果发现任何一个投票值为0，说明还有未完成的投票
            if (vote == 0) {
                return false;  // 直接返回false，表示不是所有投票都已经进入
            }
        }
        // 如果没有找到任何投票值为0，返回true，表示所有投票都已经进入
        return true;
    }

   /* private boolean allVotesIn() {

        return votes.values().stream().noneMatch(v -> v == 0);
    }*/

    public boolean isMember(User user) throws MedicalCaseException{
       for (User u : members){
           if(members.contains(user)){
                return true;
           }
       }
       throw new MedicalCaseException("User is not a member jet");
    }

}