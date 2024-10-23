import { cookies } from 'next/headers';
import { getCurrentToken, getUserProfile, saveGoogleToken } from './data/auth';
import { hasAccess, hasUser, isFirstAccess } from './data/user';

const NO_AUTH_ROUTE = ['/signin', '/welcome', '/signup'];
const AUTH_ROUTE = ['/home'];

export function middleware(request) {
  const { pathname, searchParams } = request.nextUrl;
  const token = searchParams.get('token');

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

  if (!getCurrentToken() && !token && AUTH_ROUTE.some(route => route === pathname)) { 
    return Response.redirect(new URL('/welcome', request.url));
  }
}

export const config = {
  matcher: ['/((?!api|_next/static|_next/image|.*\\.png$).*)'],
};
