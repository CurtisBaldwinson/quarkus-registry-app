package io.quarkus.registry.app.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.databind.JsonNode;

@Entity
public class Extension extends BaseEntity {
    public String groupId;
    public String artifactId;

    public String name;
    public String description;

    @ManyToOne
    public Category category;

    @Column(columnDefinition = "json")
    public JsonNode metadata;

    @OneToMany
    public List<ExtensionRelease> releases;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Extension)) {
            return false;
        }
        Extension extension = (Extension) o;
        return Objects.equals(groupId, extension.groupId) && Objects.equals(artifactId, extension.artifactId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, artifactId);
    }

}
