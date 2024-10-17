import { cookies } from 'next/headers';
import { redirect } from 'next/navigation';
import { split } from 'postcss/lib/list';
import { ConfirmForm } from '@/components/ConfirmForm/ConfirmForm';

const IdPage = ({ params }) => {
  const tokenCookie = cookies().get('token');

  if (!tokenCookie) {
    console.error('Token no encontrado en la cookies');

    redirect('/welcome');
  }

  const token = tokenCookie.value;

  console.log('aqui el otro token:', token);

  let decodeEmail;

  try {
    decodeEmail = getTokenEmail(token);
  } catch (err) {
    console.error('ID inválido o no coincide con el token:', err);

    redirect('/welcome');
  }

  if (!decodeEmail) {
    console.error('ID inválido o no coincide con el token');
    redirect('/welcome');

    return;
  }

  return (
    <div className="mt-20 w-full">
      <ConfirmForm />
    </div>
  );
};

function getTokenEmail(token) {
  const base64Url = token.split('.')[1];
  const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
  const jsonPayload = decodeURIComponent(
    atob(base64)
      .split('')
      .map(c => `%${('00' + c.charCodeAt(0).toString(16)).slice(-2)}`)
      .join('')
  );

  const payload = JSON.parse(jsonPayload);

  return payload.sub;
}

export default IdPage;
