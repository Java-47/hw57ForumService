package telran.java47.forum.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class PeriodCreateDto {
	LocalDate dateFrom;
	LocalDate dateTo;
}
