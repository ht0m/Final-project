package berthbooking.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PortDto {

    private Long id;

    @NotNull
    @Schema(description="Name of the Port", example = "Keszthely")
    private String portName;

    @NotNull
    @Schema(description="Email of the port", example = "keszthely@balaport.hu")
    private String email;

    @NotNull
    @Schema(description="Number of guest berths", example = "5")
    private int numberOfGuestBerths;

    private List<BerthDto> berths = new ArrayList<>();

    public PortDto(String portName, String email, int numberOfGuestBerths) {
        this.portName = portName;
        this.email = email;
        this.numberOfGuestBerths = numberOfGuestBerths;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PortDto portDto = (PortDto) o;
        return numberOfGuestBerths == portDto.numberOfGuestBerths && Objects.equals(portName, portDto.portName) && Objects.equals(email, portDto.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(portName, email, numberOfGuestBerths);
    }
}
