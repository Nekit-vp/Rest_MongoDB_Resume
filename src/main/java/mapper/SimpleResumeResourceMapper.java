package mapper;

import com.example.restMongoDB.model.Resume;
import com.example.restMongoDB.resource.ResumeResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SimpleResumeResourceMapper {
    Resume resourceToResume(ResumeResource resumeResource);
    ResumeResource resumeToResource(Resume resume);
}
