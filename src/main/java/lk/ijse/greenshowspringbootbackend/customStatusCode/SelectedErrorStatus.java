package lk.ijse.greenshowspringbootbackend.customStatusCode;

import lk.ijse.greenshowspringbootbackend.dto.status.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedErrorStatus implements Status {

    private int errorCode;
    private String errorMessage;

}
