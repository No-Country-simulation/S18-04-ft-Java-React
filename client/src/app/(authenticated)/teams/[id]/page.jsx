// Ruta dinamica en este caso el ID de la team
// Puedes verlo en "teams/:id". Ejemplo: "/teams/1", "/teams/123", "/teams/456"
const TeamIdPage = ({ params }) => {
  // Se puede recuperar la variable params si tu ruta es dinamica
  // Y con el nombre que le pusiste a la capreta "[]"
  // podras recuperar el valor en este caso "id"
  return (
    <div>
      <main>TeamIdPage page. ID is: {params.id}</main>
    </div>
  );
};

export default TeamIdPage;
