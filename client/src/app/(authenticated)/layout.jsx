import { AuthFooter } from '@/components/AuthFooter/AuthFooter';
import { AuthHeader } from '@/components/AuthHeader/AuthHeader';

export default function LayoutAuthenticated({ children }) {
  return (
    <div className="flex size-full min-h-screen flex-col">
      <AuthHeader />
      {children}
      <AuthFooter />
    </div>
  );
}
