import { getCurrentToken, getUserProfile, saveGoogleToken } from './data/auth';
import { hasAccess, hasUser, isFirstAccess } from './data/user';

const NO_AUTH_ROUTE = ['/signin', '/welcome', '/signup'];
const AUTH_ROUTE = ['/home'];

export function middleware(request) {
  const { pathname, searchParams } = request.nextUrl;
  const token = searchParams.get('token');
  if(token){
    
    //saveGoogleToken(token);
    const response = new Response('Token procesado', {
      status: 200, // O cualquier otro estado que necesites
    });

    // Aquí puedes configurar la cookie
    response.cookies.set('myToken', token, {
      httpOnly: false, // Para que la cookie no sea accesible desde JavaScript
      secure: process.env.NODE_ENV === 'production', // Solo enviar por HTTPS en producción
      path: '/', // Establecer el path donde la cookie es válida
      maxAge: 60 * 60 * 24 * 7, // 1 día en segundos
    });

    // Eliminar el parámetro 'token' de la URL
    searchParams.delete('token');
    
    // Crear una nueva URL sin el parámetro 'token'
    const newUrl = new URL(request.url);
    newUrl.search = searchParams.toString();  // Actualizar la cadena de consulta

    // Redirigir a la nueva URL sin el parámetro 'token'
    return Response.redirect(newUrl);
  }
  if (hasUser() && NO_AUTH_ROUTE.some(route => route === pathname)) {
    return Response.redirect(new URL('/home', request.url));
  }

  if (pathname.startsWith('/signup/confirm')) {
    const pathParts = pathname.split('/');
    //TODO: Hay que validar que el Id de la ruta sea correcto
    const pathUserId = pathParts[3];
   /* if (pathParts.length > 3) {
      getUserProfile().then(user => {
        console.log({ user })
        if(!user){
          return Response.redirect(new URL('/home', request.url));
        }
      })
    }*/
  }

  /*if ((!hasUser() || !getCurrentToken()) && AUTH_ROUTE.some(route => route === pathname)) {
    return Response.redirect(new URL('/welcome', request.url));
  }*/
}

export const config = {
  matcher: ['/((?!api|_next/static|_next/image|.*\\.png$).*)'],
};
