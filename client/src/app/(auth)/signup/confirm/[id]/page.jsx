import { ConfirmForm } from '@/components/ConfirmForm/ConfirmForm';

<<<<<<< HEAD
const IdPage = ({ params }) => {
  const userString = cookies().get('token');
  let obj;
  try {
    obj = userString && userString?.value ? JSON.parse(userString.value) : {};
  } catch (e) {
    redirect('/welcome');
  }

  if (obj.id !== params.id) {
    console.error('Token no encontrado en la cookies');
    redirect('/welcome');
  }

  return (
    <div className="mt-20 w-full">
      <ConfirmForm />
    </div>
  );
=======
const IdPage = () => {
  return <ConfirmForm />;
>>>>>>> d9077d97c6a4b4da1554bf47bdddffbccafba5da
};

export default IdPage;
