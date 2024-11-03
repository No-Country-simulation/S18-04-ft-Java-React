<p align="center">
<img src="https://res.cloudinary.com/dcq6ecx2k/image/upload/v1730658107/pbwaemm0jcrvcsywa8gm.png" alt="Logo No Country" width="100%" height="auto"/>
</p>

<div align="center">

![Estado del Proyecto](https://img.shields.io/badge/Estado-Terminado-green)
![PRs Welcome](https://img.shields.io/badge/PRs-welcome-green)
<br>

![Java](https://img.shields.io/badge/Java-007396?logo=java&logoColor=white&color=007396)
![Spring Boot](https://img.shields.io/badge/Spring--Boot-6DB33F?logo=spring-boot&logoColor=white&color=6DB33F)
![Spring Security](https://img.shields.io/badge/Spring--Security-6DB33F?logo=spring-security&logoColor=white&color=6DB33F)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-336791?logo=postgresql&logoColor=white&color=336791)
![React](https://img.shields.io/badge/React-20232A?logo=react&logoColor=61DAFB&color=61DAFB)
![Next.js](https://img.shields.io/badge/Next.js-000000?logo=next.js&logoColor=white&color=000000)
![JWT](https://img.shields.io/badge/JWT-black?logo=json-web-tokens&logoColor=white&color=black)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?logo=swagger&logoColor=black&color=85EA2D)
![Postman](https://img.shields.io/badge/Postman-FF6C37?logo=postman&logoColor=white&color=FF6C37)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?logo=thymeleaf&logoColor=white&color=005F0F)
![Google Auth](https://img.shields.io/badge/Google-4285F4?logo=google&logoColor=white&color=4285F4)
![TailwindCSS](https://img.shields.io/badge/TailwindCSS-06B6D4?logo=tailwindcss&logoColor=white&color=06B6D4)

</div>


<h1 align="center">Equipo S18-04-ft-Java-React</h1

                                                
<br>

**No Country App** es una aplicación diseñada para facilitar el registro de perfiles en simulaciones laborales recurrentes organizadas por No Country Simulation. Esta app permite a los usuarios crear un perfil único donde se almacena toda su información profesional relevante (stack tecnológico, experiencia, etc.), de manera que solo necesiten agregar algunos detalles específicos para cada simulación. Esta funcionalidad elimina la necesidad de ingresar desde cero toda la información en cada evento, haciendo el proceso más eficiente y sencillo.

## Vistas de la Aplicación

Aquí tienes una vista previa de las pantallas principales de la app:

![Vistas de la Aplicación](https://res.cloudinary.com/dcq6ecx2k/image/upload/v1730561330/xrnumwbfbks9wemziztk.png)

## Enlace al Diseño en Figma

Para visualizar el diseño de la aplicación, consulta el enlace a Figma a continuación:

- **Enlace al diseño en Figma:** [No Country App - Figma](https://www.figma.com/design/SdEGl2OiZOUwA0SHGljEyb/No-Country-App)



## Requerimientos del Proyecto

Para más información sobre los requerimientos y funcionalidades, consulta el siguiente documento:

- [Documentación de Requerimientos](https://docs.google.com/document/d/1m3cfRQRfbDSGD2LNHfpChX33HrbRxtJCkP8uqvSLv-M/edit?tab=t.0#heading=h.r2bw3box34ax)




## Características Principales

- **Perfil Único**: Almacena los detalles profesionales de los usuarios, facilitando el registro en cada simulación sin necesidad de ingresar la misma información repetidamente.
- **Simulaciones Laborales**: Los usuarios pueden inscribirse rápidamente a las simulaciones mensuales, seleccionando solo la información específica requerida para cada evento.
- **Interfaz Intuitiva**: La aplicación cuenta con un diseño simple y accesible, facilitando la experiencia del usuario.
- **Compatibilidad Multiplataforma**: Acceso desde diferentes dispositivos para mayor flexibilidad.

## Instalación y Ejecución

### Prerrequisitos

Asegúrate de tener instalado lo siguiente antes de iniciar la aplicación:

- **Java 21** o superior
- **Node.js** (versión 20 o superior)
- **PostgreSQL** como base de datos

### Configuración

1. Clona este repositorio en tu máquina local:
   ```bash
   git clone https://github.com/No-Country-simulation/S18-04-ft-Java-React.git
   cd S18-04-ft-Java-React
   ```

2. Configuración de PostgreSQL
   - Crea una base de datos en PostgreSQL.
   - En src/main/resources/application.properties, agrega:
   ```bash
   spring.datasource.url=jdbc:postgresql://localhost:5432/tu_base_datos
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   ```

3. Configura las variables de entorno en tu archivo .env.
4. Ejecución del Backend:
   ```bash
   ./mvnw spring-boot:run
   ```
   
5. Ejecución del Frontend:
   ```bash
   npm install
   npm run dev
   ```

    
## Organización

[![Slack](https://img.shields.io/badge/Slack-4A154B?style=for-the-badge&logo=slack&logoColor=white)](https://slack.com)
[![Discord](https://img.shields.io/badge/Discord-7289DA?style=for-the-badge&logo=discord&logoColor=white)](https://discord.com)
[![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com)
[![Project](https://img.shields.io/badge/Project-00A86B?style=for-the-badge&logo=github&logoColor=white)](https://github.com/orgs/No-Country-simulation/projects/92)
[![WhatsApp](https://img.shields.io/badge/WhatsApp-25D366?style=for-the-badge&logo=whatsapp&logoColor=white)](https://wa.me/1234567890) <!-- Reemplaza el número de teléfono con el adecuado -->
[![Figma](https://img.shields.io/badge/Figma-F24E1E?style=for-the-badge&logo=figma&logoColor=white)](https://www.figma.com)


## Documentación de API

La documentación de la API se puede acceder a través de Swagger. Utiliza la siguiente URL para ver todos los endpoints disponibles, así como los detalles sobre las solicitudes y respuestas.

[Ver Documentación de API en Swagger](https://nocountry.up.railway.app/swagger-ui/index.html)


## Agradecimientos

Este proyecto fue posible gracias a la organización de simulaciones laborales por parte de [No Country](https://www.nocountry.tech/). Agradecemos a todo su equipo por brindar un espacio donde los desarrolladores pueden poner en práctica sus habilidades y colaborar en proyectos reales, contribuyendo al crecimiento profesional de todos los participantes.


## Autores

Proyecto creado por:

<table style="display: flex; justify-content: center;">
  <tr align="center">
    <td>
      <div style="display: flex; align-items: center;">
        <img src="https://github.com/anderson2093.png?size=100" alt="Anderson Cusma" style="border-radius: 50%; margin-right: 10px;">
        <p>
          <strong>Anderson Cusma</strong> | PM
        </p>
      </div>
      <div>
        <a href="https://github.com/anderson2093" style="text-decoration: none;">
          <img src="https://img.shields.io/badge/GitHub-anderson2093-blue" alt="GitHub">
        </a>
        <a href="https://www.linkedin.com/in/anderson-cusma-vasquez/" style="text-decoration: none;">
          <img src="https://img.shields.io/badge/LinkedIn-Anderson%20Cusma-blue?style=flat-square" alt="LinkedIn">
        </a>
      </div>
    </td>
    <td>
      <div style="display: flex; align-items: center;">
        <img src="https://github.com/BrendaComas.png?size=100" alt="Brenda Comas" style="border-radius: 50%; margin-right: 10px;">
        <p>
          <strong>Brenda Comas</strong> | UX/UI
        </p>
      </div>
      <div>
        <a href="https://github.com/BrendaComas" style="text-decoration: none;">
          <img src="https://img.shields.io/badge/GitHub-BrendaComas-blue" alt="GitHub">
        </a>
        <a href="https://www.linkedin.com/in/brendacomas/" style="text-decoration: none;">
          <img src="https://img.shields.io/badge/LinkedIn-Brenda%20Comas-blue?style=flat-square" alt="LinkedIn">
        </a>
        <a href="https://www.behance.net/BrendaComas" style="text-decoration: none;">
          <img src="https://img.shields.io/badge/Behance-Brenda%20Comas-blue?style=flat-square" alt="Behance">
        </a>
      </div>
    </td>
    <td>
      <div style="display: flex; align-items: center;">
        <img src="https://github.com/Catriel-Escobar.png?size=100" alt="Catriel Escobar" style="border-radius: 50%; margin-right: 10px;">
        <p>
          <strong>Catriel Escobar</strong> | Back-End
        </p>
      </div>
      <div>
        <a href="https://github.com/Catriel-Escobar" style="text-decoration: none;">
          <img src="https://img.shields.io/badge/GitHub-CatrielEscobar-blue" alt="GitHub">
        </a>
        <a href="https://www.linkedin.com/in/catrielescobar/" style="text-decoration: none;">
          <img src="https://img.shields.io/badge/LinkedIn-Catriel%20Escobar-blue?style=flat-square" alt="LinkedIn">
        </a>
      </div>
    </td>
  </tr>
  <tr align="center">
    <td>
      <div style="display: flex; align-items: center;">
        <img src="https://github.com/DVTecno.png?size=100" alt="Diego Veras" style="border-radius: 50%; margin-right: 10px;">
        <p>
          <strong>Diego Veras</strong> | Back-end
        </p>
      </div>
      <div>
        <a href="https://github.com/DVTecno" style="text-decoration: none;">
          <img src="https://img.shields.io/badge/GitHub-DVTecno-blue" alt="GitHub">
        </a>
        <a href="https://www.linkedin.com/in/diego-cristian-alfredo-v-54b459249/" style="text-decoration: none;">
          <img src="https://img.shields.io/badge/LinkedIn-Diego_Cristian_Alfredo_Veras-blue" alt="LinkedIn">
        </a>
      </div>
    </td>
    <td>
      <div style="display: flex; align-items: center;">
        <img src="https://github.com/MarcossIC.png?size=100" alt="Marcos Lopez" style="border-radius: 50%; margin-right: 10px;">
        <p>
          <strong>Marcos Lopez</strong> | Front-End
        </p>
      </div>
      <div>
        <a href="https://github.com/MarcossIC" style="text-decoration: none;">
          <img src="https://img.shields.io/badge/GitHub-MarcossIC-blue" alt="GitHub">
        </a>
        <a href="https://www.linkedin.com/in/marcos-lopez-dev/" style="text-decoration: none;">
          <img src="https://img.shields.io/badge/LinkedIn-Marcos%20López-blue?style=flat-square" alt="LinkedIn">
        </a>
      </div>
    </td>
    <td>
      <div style="display: flex; align-items: center;">
        <img src="https://github.com/milenkandrade.png?size=100" alt="Marcia Andrade" style="border-radius: 50%; margin-right: 10px;">
        <p>
          <strong>Marcia Andrade</strong> | Front-End
        </p>
      </div>
      <div>
        <a href="https://github.com/milenkandrade" style="text-decoration: none;">
          <img src="https://img.shields.io/badge/GitHub-milenkandrade-blue" alt="GitHub">
        </a>
        <a href="https://www.linkedin.com/in/marcia-milenka-andrade-llanos/" style="text-decoration: none;">
        <img src="https://img.shields.io/badge/LinkedIn-Marcia%20Milenka%20Andrade-blue?style=flat-square" alt="LinkedIn">
        </a>
      </div>
    </td>
  </tr>
  <tr align="center">
    <td>
      <div style="display: flex; align-items: center;">
        <img src="https://github.com/rogelioolarte.png?size=100" alt="Rogelio Olarte" style="border-radius: 50%; margin-right: 10px; height: 100px; width: 100px;">
        <p>
          <strong>Rogelio Olarte</strong> | Back-End
        </p>
      </div>
      <div>
        <a href="https://github.com/rogelioolarte" style="text-decoration: none;">
          <img src="https://img.shields.io/badge/GitHub-rogelioolarte-blue" alt="GitHub">
        </a>
        <a href="https://www.linkedin.com/in/rogelio-olarte/" style="text-decoration: none;">
          <img src="https://img.shields.io/badge/LinkedIn-Rogelio%20Olarte-blue?style=flat-square" alt="LinkedIn">
        </a>
      </div>
    </td>
    <td>
      <div style="display: flex; align-items: center;">
        <img src="https://github.com/SoyIsabelMM.png?size=100" alt="Mary Isabel Martinez" style="border-radius: 50%; margin-right: 10px;">
        <p>
          <strong>Mary Isabel Martinez</strong> | Front-End
        </p>
      </div>
      <div>
        <a href="https://github.com/SoyIsabelMM" style="text-decoration: none;">
          <img src="https://img.shields.io/badge/GitHub-SoyIsabelMM-blue" alt="GitHub">
        </a>
        <a href="https://www.linkedin.com/in/soyisabelmm/" style="text-decoration: none;">
          <img src="https://img.shields.io/badge/LinkedIn-Isabel%20M.-blue?style=flat-square" alt="LinkedIn">
        </a>
      </div>
    </td>
  </tr>
</table>



<p align="center">
    <img src="https://github.com/ximenaellis.png?size=100" alt="Ximena Ellis" style="border-radius: 50%; width: 100px; height: 100px;">
    <br>
    <strong>Ximena Ellis</strong> | Team Leader
</p>

<p align="center">
Ximena fue una líder inspiradora, impulsando al equipo con entusiasmo y comprensión de la problemática. Su conocimiento en diseño ayudo nuestras decisiones en la app, y sus habilidades blandas fortalecieron la cohesión en cada sprint, siendo clave para el éxito del equipo.
</p>

<p align="center">
    <a href="https://www.behance.net/ximenaellis"><img src="https://img.shields.io/badge/Behance-Ximena_Ellis-blue" alt="Behance"></a>
    <a href="https://www.linkedin.com/in/ximenaellis/"><img src="https://img.shields.io/badge/LinkedIn-Ximena_Ellis-blue" alt="LinkedIn"></a>
    <a href="https://github.com/ximenaellis"><img src="https://img.shields.io/badge/GitHub-ximenaellis-blue" alt="GitHub"></a>
</p>


