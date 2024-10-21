import { getCurrentToken } from './data/auth';
import { hasAccess, hasUser, isFirstAccess } from './data/user';

const NO_AUTH_ROUTE = ['/signin', '/welcome', '/signup'];
const AUTH_ROUTE = ['/home'];

export function middleware(request) {
  const { pathname } = request.nextUrl;
  if (hasUser() && NO_AUTH_ROUTE.some(route => route === pathname)) {
    return Response.redirect(new URL('/home', request.url));
  }

  if (pathname.startsWith('/signup/confirm')) {
    const pathParts = pathname.split('/');
    const pathUserId = pathParts[3];
    if (pathParts.length > 3 && (!hasAccess(pathUserId) || !isFirstAccess(pathUserId))) {
      return Response.redirect(new URL('/home', request.url));
    }
  }

  if ((/*!hasUser() || */!getCurrentToken()) && AUTH_ROUTE.some(route => route === pathname)) {
    return Response.redirect(new URL('/welcome', request.url));
  }
}

export const config = {
  matcher: ['/((?!api|_next/static|_next/image|.*\\.png$).*)'],
};
