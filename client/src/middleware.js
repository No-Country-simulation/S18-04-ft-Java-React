export function middleware(request) {
  const user = request.cookies.get('USER')?.value;

  console.log('---------------------------------------------------------');
  console.log({ cookiess: request.cookies });
  console.log({ cookie: request.cookies.get('token') });
  console.log({ token: user });
  console.log('---------------------------------------------------------');
  if (!user && request.nextUrl.pathname.startsWith('/home')) {
    return Response.redirect(new URL('/', request.url));
  }
}

export const config = {
  matcher: ['/((?!api|_next/static|_next/image|.*\\.png$).*)'],
};
