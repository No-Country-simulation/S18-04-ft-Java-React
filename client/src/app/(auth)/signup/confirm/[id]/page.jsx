import { cookies } from 'next/headers';
import { redirect } from 'next/navigation';
import { ConfirmForm } from '@/components/ConfirmForm/ConfirmForm';

const IdPage = ({ params }) => {
  const userString = cookies().get('USER');
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
};

export default IdPage;
