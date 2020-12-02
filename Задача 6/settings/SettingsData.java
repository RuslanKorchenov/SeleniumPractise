package settings;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SettingsData {
    private String username;
    private String password;
    private String site;
    private String width;
    private String height;
}
