package softuni.exam.instagraphlite.models.dto;

import softuni.exam.instagraphlite.models.entity.User;

public class UserExportDto {

    private User user;
    private int countPosts;

    public UserExportDto() {
    }

    public UserExportDto(User user, int countPosts) {
        this.user = user;
        this.countPosts = countPosts;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCountPosts() {
        return countPosts;
    }

    public void setCountPosts(int countPosts) {
        this.countPosts = countPosts;
    }
}
