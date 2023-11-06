import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {
    @Bean
    fun openApi(): OpenAPI {
        return OpenAPI()
                .components(Components())
                .info(apiInfo())
    }

    private fun apiInfo() = Info()
            .title("Kopring Study Swagger UI")
            .description("Springdoc Swagger UI")
            .version("1.0.0")
}